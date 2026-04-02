package com.microservices.demo.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.demo.dto.BatchDTO;
import com.microservices.demo.dto.DispenseDTO;
import com.microservices.demo.dto.DispenseDetailsResponseDTO;
import com.microservices.demo.dto.ProductDTO;
import com.microservices.demo.entity.Dispense;
import com.microservices.demo.exception.DispenseException;
import com.microservices.demo.exception.InvalidOperationException;
import com.microservices.demo.exception.ResourceNotFoundException;
import com.microservices.demo.repository.DispenseRepository;
import com.microservices.demo.service.DispenseService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DispenseServiceImpl implements DispenseService {

    @Autowired
    private DispenseRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    // ✅ Ideally move to application.yml
    private static final String PRODUCT_SERVICE =
            "Product-Service";

    private static final String BATCH_SERVICE =
            "Batch-Service";

    // ==========================
    // CORE CRUD
    // ==========================

    @Override
    public DispenseDTO createDispense(DispenseDTO dto) {
        validate(dto);

        Dispense dispense = mapToEntity(dto);
        dispense.setDispensedAt(LocalDateTime.now());
        dispense.setStatus("PENDING");

        return mapToDTO(repo.save(dispense));
    }

    @Override
    public List<DispenseDTO> getAllDispenses() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DispenseDTO getDispenseById(Long id) {
        Dispense dispense = getEntity(id);
        return mapToDTO(dispense);
    }

    @Override
    public DispenseDTO updateDispense(Long id, DispenseDTO dto) {
        Dispense dispense = getEntity(id);

        if (dto.getQuantity() != null) dispense.setQuantity(dto.getQuantity());
        if (dto.getPurpose() != null) dispense.setPurpose(dto.getPurpose());
        if (dto.getDispensedBy() != null) dispense.setDispensedBy(dto.getDispensedBy());

        return mapToDTO(repo.save(dispense));
    }

    @Override
    public void deleteDispenseById(Long id) {
        Dispense dispense = getEntity(id);
        repo.delete(dispense);
    }

    // ==========================
    // FILTERS
    // ==========================

    @Override
    public List<DispenseDTO> getDispenseByPatientId(String patientId) {
        return repo.findByPatientId(patientId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DispenseDTO> getDispenseByWardId(String wardId) {
        return repo.findByWardId(wardId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DispenseDTO> getDispenseByStatus(String status) {
        return repo.findByStatus(status)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ==========================
    // STATUS MANAGEMENT
    // ==========================

    @Override
    public DispenseDTO confirmDispense(Long id) {
        Dispense dispense = getEntity(id);

        if (!"PENDING".equals(dispense.getStatus())) {
            throw new InvalidOperationException(
                    "Confirm Dispense",
                    "Only PENDING dispenses can be confirmed"
            );
        }

        dispense.setStatus("COMPLETED");
        return mapToDTO(repo.save(dispense));
    }

    @Override
    public DispenseDTO cancelDispense(Long id, String reason) {
        Dispense dispense = getEntity(id);

        if ("COMPLETED".equals(dispense.getStatus())) {
            throw new InvalidOperationException(
                    "Cancel Dispense",
                    "Completed dispense cannot be cancelled"
            );
        }

        dispense.setStatus("CANCELLED");
        return mapToDTO(repo.save(dispense));
    }

    // ==========================
    // ✅ DETAILS WITH PRODUCT + BATCH
    // ==========================

    @Override


    public DispenseDetailsResponseDTO getDispenseDetails(Long id) {

        Dispense dispense = getEntity(id);
        DispenseDTO dispenseDTO = mapToDTO(dispense);

        // ✅ Correct Product API call
        ProductDTO product = restTemplate.getForObject(
                "http://PRODUCT-SERVICE/api/products/id/" + dispenseDTO.getProductId(),
                ProductDTO.class
        );

        // ✅ Correct Batch API call
        BatchDTO batch = restTemplate.getForObject(
                "http://BATCH-SERVICE/api/batches/" + dispenseDTO.getBatchId(),
                BatchDTO.class
        );

        return new DispenseDetailsResponseDTO(dispenseDTO, product, batch);
    }
    
    @CircuitBreaker(
            name = PRODUCT_SERVICE,
            fallbackMethod = "productFallback"
    )
    public ProductDTO getProduct(Long productId) {

        return restTemplate.getForObject(
                "http://PRODUCT-SERVICE/api/products/id/" + productId,
                ProductDTO.class
        );
    }
    
    
    public ProductDTO productFallback(Long productId, Throwable ex) {

        ProductDTO fallback = new ProductDTO();
        fallback.setProductId(productId);
        fallback.setName("PRODUCT SERVICE UNAVAILABLE");
        fallback.setStatus("UNKNOWN");

        return fallback;
    }
    
    
    @CircuitBreaker(
            name = BATCH_SERVICE,
            fallbackMethod = "batchFallback"
    )
    public BatchDTO getBatch(Long batchId) {

        return restTemplate.getForObject(
                "http://BATCH-SERVICE/api/batches/" + batchId,
                BatchDTO.class
        );
    }
    
    
    public BatchDTO batchFallback(Long batchId, Throwable ex) {

        BatchDTO fallback = new BatchDTO();
        fallback.setBatchId(batchId);
        fallback.setStatus("UNKNOWN");

        return fallback;
    }
    
    // ==========================
    // VALIDATION
    // ==========================

    private void validate(DispenseDTO dto) {
        if (dto.getQuantity() == null || dto.getQuantity() <= 0)
            throw new DispenseException("Create Dispense", "Quantity must be > 0");

        if (dto.getPatientId() == null || dto.getPatientId().isBlank())
            throw new DispenseException("Create Dispense", "Patient ID is required");

        if (dto.getWardId() == null || dto.getWardId().isBlank())
            throw new DispenseException("Create Dispense", "Ward ID is required");

        if (dto.getBatchId() == null || dto.getProductId() == null)
            throw new DispenseException("Create Dispense", "Batch & Product ID required");
    }
    
    //FALLBACK method
    public DispenseDetailsResponseDTO dispenseDetailsFallback(Long id, Throwable ex) {

        Dispense dispense = getEntity(id);
        DispenseDTO dispenseDTO = mapToDTO(dispense);

        // Minimal safe fallback objects
        ProductDTO productFallback = new ProductDTO();
        productFallback.setProductId(dispenseDTO.getProductId());
        productFallback.setName("PRODUCT SERVICE UNAVAILABLE");
        productFallback.setStatus("UNKNOWN");

        BatchDTO batchFallback = new BatchDTO();
        batchFallback.setBatchId(dispenseDTO.getBatchId());
        productFallback.setName("BATCH SERVICE UNAVAILABLE");
        batchFallback.setStatus("UNKNOWN");

        return new DispenseDetailsResponseDTO(
                dispenseDTO,
                productFallback,
                batchFallback
        );
    }

    // ==========================
    // HELPERS
    // ==========================

    private Dispense getEntity(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dispense", id));
    }

    private DispenseDTO mapToDTO(Dispense dispense) {
        DispenseDTO dto = new DispenseDTO();
        dto.setDispenseId(dispense.getDispenseId());
        dto.setBatchId(dispense.getBatch());
        dto.setProductId(dispense.getProduct());
        dto.setPatientId(dispense.getPatientId());
        dto.setWardId(dispense.getWardId());
        dto.setQuantity(Optional.ofNullable(dispense.getQuantity()).orElse(0));
        dto.setDispensedAt(dispense.getDispensedAt());
        dto.setDispensedBy(dispense.getDispensedBy());
        dto.setPurpose(dispense.getPurpose());
        dto.setStatus(dispense.getStatus());
        return dto;
    }

    private Dispense mapToEntity(DispenseDTO dto) {
        Dispense dispense = new Dispense();
        dispense.setBatch(dto.getBatchId());
        dispense.setProduct(dto.getProductId());
        dispense.setPatientId(dto.getPatientId());
        dispense.setWardId(dto.getWardId());
        dispense.setQuantity(dto.getQuantity());
        dispense.setDispensedBy(dto.getDispensedBy());
        dispense.setPurpose(dto.getPurpose());
        return dispense;
    }
}