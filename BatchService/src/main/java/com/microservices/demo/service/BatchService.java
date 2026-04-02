package com.microservices.demo.service;


import java.util.List;
import com.microservices.demo.dto.BatchDTO;
import com.microservices.demo.dto.BatchDetailsResponseDTO;

public interface BatchService {

    BatchDTO save(BatchDTO batchDTO);

    List<BatchDTO> getAll();

    BatchDTO getById(Long id);

    List<BatchDTO> getByProduct(Long productId);

    void delete(Long id);

    // ✅ NEW: Batch + Product details
    BatchDetailsResponseDTO getBatchDetails(Long batchId);
}