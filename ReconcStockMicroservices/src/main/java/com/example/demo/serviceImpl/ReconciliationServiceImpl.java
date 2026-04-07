package com.example.demo.serviceImpl;

import com.example.demo.DTO.ReconciliationDTO;
import com.example.demo.entities.Reconciliation;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ReconciliationRepository;
import com.example.demo.service.ReconciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReconciliationServiceImpl implements ReconciliationService {

    @Autowired
    private ReconciliationRepository reconciliationRepository;

    @Override
    public ReconciliationDTO createReconciliation(ReconciliationDTO reconciliationDTO) {
        Reconciliation reconciliation = new Reconciliation();
        reconciliation.setCountId(reconciliationDTO.getCountId());
        reconciliation.setExpectedQuantity(reconciliationDTO.getExpectedQuantity());
        reconciliation.setCountedQuantity(reconciliationDTO.getCountedQuantity());
        reconciliation.setVariance(reconciliationDTO.getVariance());
        reconciliation.setAdjustedBy(reconciliationDTO.getAdjustedBy());
        reconciliation.setAdjustedAt(reconciliationDTO.getAdjustedAt());
        reconciliation.setStatus(reconciliationDTO.getStatus());
        reconciliation = reconciliationRepository.save(reconciliation);
        return convertToDTO(reconciliation);
    }

    @Override
    public ReconciliationDTO getReconciliationById(Long id) {
        Reconciliation reconciliation = reconciliationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reconciliation not found"));
        return convertToDTO(reconciliation);
    }

    @Override
    public List<ReconciliationDTO> getAllReconciliations() {
        return reconciliationRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ReconciliationDTO updateReconciliation(Long id, ReconciliationDTO reconciliationDTO) {
        Reconciliation reconciliation = reconciliationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reconciliation not found"));
        reconciliation.setCountId(reconciliationDTO.getCountId());
        reconciliation.setExpectedQuantity(reconciliationDTO.getExpectedQuantity());
        reconciliation.setCountedQuantity(reconciliationDTO.getCountedQuantity());
        reconciliation.setVariance(reconciliationDTO.getVariance());
        reconciliation.setAdjustedBy(reconciliationDTO.getAdjustedBy());
        reconciliation.setAdjustedAt(reconciliationDTO.getAdjustedAt());
        reconciliation.setStatus(reconciliationDTO.getStatus());
        reconciliation = reconciliationRepository.save(reconciliation);
        return convertToDTO(reconciliation);
    }

    @Override
    public void deleteReconciliation(Long id) {
        Reconciliation reconciliation = reconciliationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reconciliation not found"));
        reconciliationRepository.delete(reconciliation);
    }

    private ReconciliationDTO convertToDTO(Reconciliation reconciliation) {
        ReconciliationDTO dto = new ReconciliationDTO();
        dto.setReconId(reconciliation.getReconId());
        dto.setCountId(reconciliation.getCountId());
        dto.setExpectedQuantity(reconciliation.getExpectedQuantity());
        dto.setCountedQuantity(reconciliation.getCountedQuantity());
        dto.setVariance(reconciliation.getVariance());
        dto.setAdjustedBy(reconciliation.getAdjustedBy());
        dto.setAdjustedAt(reconciliation.getAdjustedAt());
        dto.setStatus(reconciliation.getStatus());
        return dto;
    }
}