package com.example.demo.service;

import com.example.demo.DTO.ReconciliationDTO;
import java.util.List;

public interface ReconciliationService {
    ReconciliationDTO createReconciliation(ReconciliationDTO reconciliationDTO);
    ReconciliationDTO getReconciliationById(Long id);
    List<ReconciliationDTO> getAllReconciliations();
    ReconciliationDTO updateReconciliation(Long id, ReconciliationDTO reconciliationDTO);
    void deleteReconciliation(Long id);
}