package com.microservices.demo.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.demo.entity.ConsumptionLog;
import com.microservices.demo.dto.ConsumptionLogDTO;
import com.microservices.demo.dto.ConsumptionLogDetailsResponseDTO;
import com.microservices.demo.dto.ProductDTO;
import com.microservices.demo.exception.ResourceNotFoundException;
import com.microservices.demo.repository.ConsumptionLogRepository;
import com.microservices.demo.service.ConsumptionLogService;

@Service
public class ConsumptionLogServiceimpl implements ConsumptionLogService {
     
	@Autowired
    private ConsumptionLogRepository repo;

    // ✅ Create RestTemplate manually
	@Autowired
    private RestTemplate restTemplate;


	  private static final String PRODUCT_SERVICE_URL =
	            "http://PRODUCT-SERVICE/api/products/id/";


  

    // ==========================
    // CREATE
    // ==========================

    @Override
    public ConsumptionLogDTO insertConsumptionLog(ConsumptionLogDTO dto) {
        ConsumptionLog log = mapToEntity(dto);
        log.setGeneratedAt(LocalDateTime.now());
        return mapToDTO(repo.save(log));
    }

    // ==========================
    // READ
    // ==========================

    @Override
    public List<ConsumptionLogDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ConsumptionLogDTO getById(Long id) {
        return repo.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() ->
                        new ResourceNotFoundException("ConsumptionLog", id));
    }

    @Override
    public List<ConsumptionLogDTO> getByProduct(Long productId) {
        return repo.findByProduct(productId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConsumptionLogDTO> getByPeriod(LocalDateTime from, LocalDateTime to) {
        return repo.findByGeneratedAtBetween(from, to)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ==========================
    // DELETE
    // ==========================

    @Override
    public void delById(long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("ConsumptionLog", id);
        }
        repo.deleteById(id);
    }

    // ==========================
    // UPDATE
    // ==========================

    @Override
    public ConsumptionLogDTO updateLog(ConsumptionLogDTO dto) {

        ConsumptionLog existing = repo.findById(dto.getLogId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("ConsumptionLog", dto.getLogId()));

        existing.setProduct(dto.getProductId());
        existing.setPeriodStart(dto.getPeriodStart());
        existing.setPeriodEnd(dto.getPeriodEnd());
        existing.setQuantityUsed(dto.getQuantityUsed());

        return mapToDTO(repo.save(existing));
    }

    // ==========================
    // ✅ DETAILS (ConsumptionLog + Product)
    // ==========================

    @Override
    public ConsumptionLogDetailsResponseDTO getConsumptionLogDetails(Long id) {

        ConsumptionLog log = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("ConsumptionLog", id));

        ConsumptionLogDTO logDTO = mapToDTO(log);

        // ✅ REST CALL
        ProductDTO product = restTemplate.getForObject(
        		PRODUCT_SERVICE_URL + logDTO.getProductId(),
                ProductDTO.class
        );

        return new ConsumptionLogDetailsResponseDTO(logDTO, product);
    }

    // ==========================
    // MAPPERS
    // ==========================

    private ConsumptionLogDTO mapToDTO(ConsumptionLog log) {
        ConsumptionLogDTO dto = new ConsumptionLogDTO();
        dto.setLogId(log.getLogId());
        dto.setProductId(log.getProduct());
        dto.setPeriodStart(log.getPeriodStart());
        dto.setPeriodEnd(log.getPeriodEnd());
        dto.setQuantityUsed(log.getQuantityUsed());
        dto.setGeneratedAt(log.getGeneratedAt());
        return dto;
    }

    private ConsumptionLog mapToEntity(ConsumptionLogDTO dto) {
        ConsumptionLog log = new ConsumptionLog();
        log.setProduct(dto.getProductId());
        log.setPeriodStart(dto.getPeriodStart());
        log.setPeriodEnd(dto.getPeriodEnd());
        log.setQuantityUsed(dto.getQuantityUsed());
        return log;
    }
}