package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.BatchDTO;
import com.example.demo.dto.ExpiryAlertDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.RequiredResponseDTO;
import com.example.demo.entities.ExpiryAlert;

import com.example.demo.repository.ExpiryAlertRepository;
import com.example.demo.service.ExpiryAlertService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ExpiryAlertServiceImpl implements ExpiryAlertService {

    // ✅ Single base URL for product + batch service
    private static final String PRODUCT_BATCH_SERVICE = "PRODUCT-BATCH-SERVICE";

    @Autowired
    private ExpiryAlertRepository expiryAlertRepo;

    @Autowired
    private RestTemplate restTemplate;

    // ==========================
    // CRUD
    // ==========================

    @Override
    public ExpiryAlertDTO save(ExpiryAlertDTO dto) {
        ExpiryAlert entity = convertDtoToEntity(dto);
        ExpiryAlert saved = expiryAlertRepo.save(entity);
        return convertEntityToDto(saved);
    }

    @Override
    public List<ExpiryAlertDTO> getAll() {
        return expiryAlertRepo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExpiryAlertDTO getById(Long id) {
        return expiryAlertRepo.findById(id)
                .map(this::convertEntityToDto)
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        expiryAlertRepo.deleteById(id);
    }

    @Override
    public ExpiryAlertDTO update(ExpiryAlertDTO dto) {
        if (dto.getAlertId() == null) return null;
        ExpiryAlert entity = convertDtoToEntity(dto);
        ExpiryAlert saved = expiryAlertRepo.save(entity);
        return convertEntityToDto(saved);
    }

    // ==========================
    // Combined Response (Alert + Product + Batch)
    // ==========================

    @Override
    @CircuitBreaker(name = PRODUCT_BATCH_SERVICE, fallbackMethod = "fallbackProductBatchData")
    public RequiredResponseDTO getExpiryAlertDetails(Long alertId) {
        ExpiryAlert alert = expiryAlertRepo.findById(alertId)
                .orElseThrow();

        ExpiryAlertDTO alertDto = convertEntityToDto(alert);

        // ✅ Correct Product API call
        ProductDTO product = restTemplate.getForObject(
                "http://PRODUCT-BATCH-SERVICE/products/get/" + alertDto.getProductId(),
                ProductDTO.class
        );

        // ✅ Correct Batch API call
        BatchDTO batch = restTemplate.getForObject(
                "http://PRODUCT-BATCH-SERVICE/batches/get/" + alertDto.getBatchId(),
                BatchDTO.class
        );

        RequiredResponseDTO response = new RequiredResponseDTO();
        response.setAlertDto(alertDto);
        response.setProduct(product);
        response.setBatch(batch);

        return response;
    }
    
    
 // ==========================
 // Fallback Method
 // ==========================
 public RequiredResponseDTO fallbackProductBatchData(Long alertId, Throwable ex) {
     System.out.println("Product-Batch Service DOWN: " + ex.getMessage());

     ExpiryAlert alert = expiryAlertRepo.findById(alertId)
             .orElseThrow();

     ExpiryAlertDTO alertDto = convertEntityToDto(alert);

     RequiredResponseDTO response = new RequiredResponseDTO();
     response.setAlertDto(alertDto);
     response.setProduct(null); // product not available
     response.setBatch(null);   // batch not available

     return response; // return partial data instead of crashing
 }
    
    

  
    // ==========================
    // Helpers (Entity ↔ DTO)
    // ==========================

    private ExpiryAlertDTO convertEntityToDto(ExpiryAlert entity) {
        ExpiryAlertDTO dto = new ExpiryAlertDTO();
        dto.setAlertId(entity.getAlertId());
        dto.setBatchId(entity.getBatch());
        dto.setProductId(entity.getProduct());
        dto.setDaysToExpiry(entity.getDaysToExpiry());
        dto.setGeneratedAt(entity.getGeneratedAt());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    private ExpiryAlert convertDtoToEntity(ExpiryAlertDTO dto) {
        ExpiryAlert entity = new ExpiryAlert();
        entity.setAlertId(dto.getAlertId());
        entity.setBatch(dto.getBatchId());
        entity.setProduct(dto.getProductId());
        entity.setDaysToExpiry(dto.getDaysToExpiry());
        entity.setGeneratedAt(dto.getGeneratedAt());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
