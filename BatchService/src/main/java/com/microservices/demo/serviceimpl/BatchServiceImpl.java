package com.microservices.demo.serviceimpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.microservices.demo.dto.BatchDTO;
import com.microservices.demo.dto.BatchDetailsResponseDTO;
import com.microservices.demo.dto.ProductDTO;
import com.microservices.demo.entity.Batch;
import com.microservices.demo.repository.BatchRepository;
import com.microservices.demo.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    // ✅ move to application.yml later
    private static final String PRODUCT_SERVICE_URL =
            "Product-Service";

    // ==========================
    // CREATE / UPDATE
    // ==========================

    @Override
    public BatchDTO save(BatchDTO batchDTO) {
        Batch batch = mapToEntity(batchDTO);
        Batch saved = repo.save(batch);
        return mapToDTO(saved);
    }

    // ==========================
    // READ
    // ==========================

    @Override
    public List<BatchDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BatchDTO getById(Long id) {
        return repo.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public List<BatchDTO> getByProduct(Long productId) {
        return repo.findByProductId(productId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ==========================
    // ✅ BATCH + PRODUCT DETAILS
    // ==========================

    @Override
    public BatchDetailsResponseDTO getBatchDetails(Long batchId) {

        Batch batch = repo.findById(batchId).orElse(null);
        if (batch == null) {
            return null;
        }

        BatchDTO batchDTO = mapToDTO(batch);

        // Fetch product details using productId from batch
        ProductDTO product = restTemplate.getForObject(
                "http://Product-Service/api/products/id/" + batchDTO.getProductId(),
                ProductDTO.class
        );

        return new BatchDetailsResponseDTO(batchDTO, product);
    }

    // ==========================
    // DELETE
    // ==========================

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

   
    // ==========================
    // MAPPERS
    // ==========================

    private BatchDTO mapToDTO(Batch batch) {
        BatchDTO dto = new BatchDTO();
        dto.setBatchId(batch.getBatchId());
        dto.setProductId(batch.getProductId());
        dto.setLotNumber(batch.getLotNumber());
        dto.setManufacturer(batch.getManufacturer());
        dto.setManufactureDate(batch.getManufactureDate());
        dto.setExpiryDate(batch.getExpiryDate());
        dto.setQuantityReceived(batch.getQuantityReceived());
        dto.setQuantityAvailable(batch.getQuantityAvailable());
        dto.setLocationId(batch.getLocationId());
        dto.setStatus(batch.getStatus());
        return dto;
    }

    private Batch mapToEntity(BatchDTO dto) {
        Batch batch = new Batch();

        batch.setBatchId(dto.getBatchId());
        batch.setProductId(dto.getProductId());   // ✅ THIS WAS MISSING
        batch.setLotNumber(dto.getLotNumber());
        batch.setManufacturer(dto.getManufacturer());
        batch.setManufactureDate(dto.getManufactureDate());
        batch.setExpiryDate(dto.getExpiryDate());
        batch.setQuantityReceived(dto.getQuantityReceived());
        batch.setQuantityAvailable(dto.getQuantityAvailable());
        batch.setLocationId(dto.getLocationId());
        batch.setStatus(dto.getStatus());

        return batch;
    }
}