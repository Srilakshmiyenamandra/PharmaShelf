package com.microservices.demo.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.demo.entity.Returns;
import com.microservices.demo.dto.BatchDTO;
import com.microservices.demo.dto.ReturnDTO;
import com.microservices.demo.dto.ReturnDetailsResponseDTO;
import com.microservices.demo.exception.ResourceNotFoundException;
import com.microservices.demo.repository.ReturnRepository;
import com.microservices.demo.service.ReturnService;

@Service
public class Returnserviceimpl implements ReturnService {
   
	@Autowired
    private ReturnRepository repo;

    // ✅ RestTemplate created directly
	@Autowired
    private RestTemplate restTemplate;

    private static final String BATCH_SERVICE =
            "BATCH-SERVICE";

    // ==========================
    // CREATE
    // ==========================

    @Override
    public ReturnDTO createReturn(ReturnDTO dto) {
        Returns entity = mapToEntity(dto);
        entity.setReturnedAt(LocalDate.now());
        return mapToDTO(repo.save(entity));
    }

    // ==========================
    // READ
    // ==========================

    @Override
    public ReturnDTO getById(Long id) {
        return repo.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Return", id));
    }

    @Override
    public List<ReturnDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReturnDTO> getByBatch(Long batchId) {
        return repo.findByBatch(batchId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ==========================
    // DELETE
    // ==========================

    @Override
    public void deleteById(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Return", id);
        }
        repo.deleteById(id);
    }

    // ==========================
    // ✅ DETAILS (Return + Batch)
    // ==========================

    @Override
    public ReturnDetailsResponseDTO getReturnDetails(Long id) {

        Returns returns = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Return", id));

        ReturnDTO dto = mapToDTO(returns);

        BatchDTO batch = restTemplate.getForObject(
               "http://BATCH-SERVICE/api/batches/" + dto.getBatchId(),
                BatchDTO.class
        );

        return new ReturnDetailsResponseDTO(dto, batch);
    }

    // ==========================
    // MAPPERS
    // ==========================

    private ReturnDTO mapToDTO(Returns entity) {
        ReturnDTO dto = new ReturnDTO();
        dto.setReturnId(entity.getReturnId());
        dto.setBatchId(entity.getBatch());
        dto.setDispenseId(
                entity.getDispense() != null
                        ? entity.getDispense().getDispenseId()
                        : null
        );
        dto.setReason(entity.getReason());
        dto.setReturnedAt(entity.getReturnedAt());
        dto.setReturnedBy(entity.getReturnedBy());
        dto.setQuantity(entity.getQuantity());
        dto.setStatus(entity.getStatus().name());
        return dto;
    }

    private Returns mapToEntity(ReturnDTO dto) {
        Returns entity = new Returns();
        entity.setBatch(dto.getBatchId());
        entity.setReason(dto.getReason());
        entity.setReturnedBy(dto.getReturnedBy());
        entity.setQuantity(dto.getQuantity());
        entity.setStatus(Returns.Status.valueOf(dto.getStatus()));
        return entity;
    }
}