package com.microservices.demo.serviceimpl;



import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.demo.dto.BatchDTO;
import com.microservices.demo.dto.ProductDTO;
import com.microservices.demo.dto.RecallDTO;
import com.microservices.demo.dto.RecallDetailsResponseDTO;
import com.microservices.demo.entity.Recall;
import com.microservices.demo.exception.ResourceNotFoundException;
import com.microservices.demo.repository.RecallRepository;
import com.microservices.demo.service.RecallService;



@Service
public class RecallServiceImpl implements RecallService {

	@Autowired
    private  RecallRepository repo;

    // ✅ Eureka-aware RestTemplate
    @Autowired
    private RestTemplate restTemplate;

    // ✅ SERVICE NAMES (must match spring.application.name)
    private static final String PRODUCT_SERVICE_URL =
            "http://PRODUCT-SERVICE/api/products/id/";
    private static final String BATCH_SERVICE_URL =
            "http://BATCH-SERVICE/api/batches/";



    // ==========================
    // CREATE
    // ==========================

    @Override
    public RecallDTO createRecall(RecallDTO dto) {
        Recall entity = mapToEntity(dto);
        entity.setRecalledAt(LocalDate.now());
        return mapToDTO(repo.save(entity));
    }

    // ==========================
    // UPDATE
    // ==========================

    @Override
    public RecallDTO updateRecall(Long recallId, RecallDTO dto) {

        Recall existing = repo.findById(recallId)
                .orElseThrow(() -> new ResourceNotFoundException("Recall", recallId));

        existing.setProductId(dto.getProductId());
        existing.setBatchId(dto.getBatchId());
        existing.setReason(dto.getReason()); 
        existing.setRecalledBy(dto.getRecalledBy());
        existing.setQuantity(dto.getQuantity());
        existing.setStatus(dto.getStatus());

        return mapToDTO(repo.save(existing));
    }

    // ==========================
    // READ
    // ==========================

    @Override
    public RecallDTO getById(Long recallId) {
        return repo.findById(recallId)
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Recall", recallId));
    }

    @Override
    public List<RecallDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ==========================
    // FILTERS
    // ==========================

    @Override
    public List<RecallDTO> getByProduct(Long productId) {
        return repo.findByProductId(productId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecallDTO> getByBatch(Long batchId) {
        return repo.findByBatchId(batchId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecallDTO> getByStatus(String status) {
        return repo.findByStatus(status)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecallDTO> getByPeriod(LocalDate from, LocalDate to) {
        return repo.findByRecalledAtBetween(from, to)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ==========================
    // VALIDATION
    // ==========================

    @Override
    public boolean isProductRecalled(Long productId) {
        return repo.existsByProductIdAndStatus(productId, "ACTIVE");
    }

    @Override
    public boolean isBatchRecalled(Long batchId) {
        return repo.existsByBatchIdAndStatus(batchId, "ACTIVE");
    }

    // ==========================
    // ✅ DETAILS (Recall + Product + Batch)
    // ==========================

    @Override
    public RecallDetailsResponseDTO getRecallDetails(Long recallId) {

        Recall recall = repo.findById(recallId)
                .orElseThrow(() -> new ResourceNotFoundException("Recall", recallId));

        RecallDTO recallDTO = mapToDTO(recall);

        // ✅ Eureka resolves PRODUCT-SERVICE
        ProductDTO product = restTemplate.getForObject(
                PRODUCT_SERVICE_URL + recallDTO.getProductId(),
                ProductDTO.class
        );

        // ✅ Eureka resolves BATCH-SERVICE
        BatchDTO batch = restTemplate.getForObject(
                BATCH_SERVICE_URL + recallDTO.getBatchId(),
                BatchDTO.class
        );

        return new RecallDetailsResponseDTO(recallDTO, product, batch);
    }

    // ==========================
    // DELETE
    // ==========================

    @Override
    public void deleteById(Long recallId) {
        if (!repo.existsById(recallId)) {
            throw new ResourceNotFoundException("Recall", recallId);
        }
        repo.deleteById(recallId);
    }

    // ==========================
    // MAPPERS
    // ==========================

    private RecallDTO mapToDTO(Recall entity) {
        RecallDTO dto = new RecallDTO();
        dto.setRecallId(entity.getRecallId());
        dto.setProductId(entity.getProductId());
        dto.setBatchId(entity.getBatchId());
        dto.setReason(entity.getReason());
        dto.setRecalledAt(entity.getRecalledAt());
        dto.setRecalledBy(entity.getRecalledBy());
        dto.setQuantity(entity.getQuantity());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    private Recall mapToEntity(RecallDTO dto) {
        Recall entity = new Recall();
        entity.setProductId(dto.getProductId());
        entity.setBatchId(dto.getBatchId());
        entity.setReason(dto.getReason());
        entity.setRecalledBy(dto.getRecalledBy());
        entity.setQuantity(dto.getQuantity());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}