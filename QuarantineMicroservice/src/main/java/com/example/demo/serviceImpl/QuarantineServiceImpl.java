package com.example.demo.serviceImpl;

import com.example.demo.DTO.BatchDTO;
import com.example.demo.DTO.QuarantineDTO;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.entities.Quarantine;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.QuarantineRepository;
import com.example.demo.service.QuarantineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuarantineServiceImpl implements QuarantineService {

    @Autowired
    private QuarantineRepository quarantineRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String BATCH_SERVICE_URL = "http://BATCHPRODUCT-SERVICE/api/v1/module42/batches/"; 
    // Replace with actual Batch service URL

    
    @Override
    public QuarantineDTO createQuarantine(QuarantineDTO quarantineDTO) {
        Quarantine quarantine = new Quarantine();
        quarantine.setBatchId(quarantineDTO.getBatchId());
        quarantine.setReason(quarantineDTO.getReason());
        quarantine.setQuarantinedBy(quarantineDTO.getQuarantinedBy());
        quarantine.setQuarantinedAt(quarantineDTO.getQuarantinedAt());
        quarantine.setReleasedBy(quarantineDTO.getReleasedBy());
        quarantine.setReleasedAt(quarantineDTO.getReleasedAt());
        quarantine.setStatus(quarantineDTO.getStatus());

        // Save to DB
        quarantine = quarantineRepository.save(quarantine);

        // Convert to DTO and return directly
        return convertToDTO(quarantine);
    }


    @Override
    public ResponseDTO getQuarantineById(Long id) {
        Quarantine quarantine = quarantineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quarantine not found"));

        QuarantineDTO quarantineDTO = convertToDTO(quarantine);

        BatchDTO batchDTO = restTemplate.getForObject(
                BATCH_SERVICE_URL + quarantine.getBatchId(),
                BatchDTO.class
        );

        return new ResponseDTO(quarantineDTO, batchDTO);
    }

    @Override
    public List<ResponseDTO> getAllQuarantines() {
        return quarantineRepository.findAll().stream().map(quarantine -> {
            QuarantineDTO quarantineDTO = convertToDTO(quarantine);
            BatchDTO batchDTO = restTemplate.getForObject(
                    BATCH_SERVICE_URL + quarantine.getBatchId(),
                    BatchDTO.class
            );
            return new ResponseDTO(quarantineDTO, batchDTO);
        }).collect(Collectors.toList());
    }

    @Override
    public ResponseDTO updateQuarantine(Long id, QuarantineDTO quarantineDTO) {
        Quarantine quarantine = quarantineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quarantine not found"));

        quarantine.setBatchId(quarantineDTO.getBatchId());
        quarantine.setReason(quarantineDTO.getReason());
        quarantine.setQuarantinedBy(quarantineDTO.getQuarantinedBy());
        quarantine.setQuarantinedAt(quarantineDTO.getQuarantinedAt());
        quarantine.setReleasedBy(quarantineDTO.getReleasedBy());
        quarantine.setReleasedAt(quarantineDTO.getReleasedAt());
        quarantine.setStatus(quarantineDTO.getStatus());

        quarantine = quarantineRepository.save(quarantine);

        QuarantineDTO updatedQuarantineDTO = convertToDTO(quarantine);

        BatchDTO batchDTO = restTemplate.getForObject(
                BATCH_SERVICE_URL + quarantine.getBatchId(),
                BatchDTO.class
        );

        return new ResponseDTO(updatedQuarantineDTO, batchDTO);
    }

    @Override
    public void deleteQuarantine(Long id) {
        Quarantine quarantine = quarantineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quarantine not found"));
        quarantineRepository.delete(quarantine);
    }

    private QuarantineDTO convertToDTO(Quarantine quarantine) {
        QuarantineDTO dto = new QuarantineDTO();
        dto.setQuarantineId(quarantine.getQuarantineId());
        dto.setBatchId(quarantine.getBatchId());
        dto.setReason(quarantine.getReason());
        dto.setQuarantinedBy(quarantine.getQuarantinedBy());
        dto.setQuarantinedAt(quarantine.getQuarantinedAt());
        dto.setReleasedBy(quarantine.getReleasedBy());
        dto.setReleasedAt(quarantine.getReleasedAt());
        dto.setStatus(quarantine.getStatus());
        return dto;
    }
}
