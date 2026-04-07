package com.example.demo.controller;

import com.example.demo.DTO.ReconciliationDTO;
import com.example.demo.service.ReconciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reconciliations")
public class ReconciliationController {

    @Autowired
    private ReconciliationService reconciliationService;

    @PostMapping
    public ResponseEntity<ReconciliationDTO> createReconciliation(@RequestBody ReconciliationDTO reconciliationDTO) {
        ReconciliationDTO createdReconciliation = reconciliationService.createReconciliation(reconciliationDTO);
        return ResponseEntity.ok(createdReconciliation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReconciliationDTO> getReconciliationById(@PathVariable Long id) {
        ReconciliationDTO reconciliation = reconciliationService.getReconciliationById(id);
        return ResponseEntity.ok(reconciliation);
    }

    @GetMapping
    public ResponseEntity<List<ReconciliationDTO>> getAllReconciliations() {
        List<ReconciliationDTO> reconciliations = reconciliationService.getAllReconciliations();
        return ResponseEntity.ok(reconciliations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReconciliationDTO> updateReconciliation(@PathVariable Long id, @RequestBody ReconciliationDTO reconciliationDTO) {
        ReconciliationDTO updatedReconciliation = reconciliationService.updateReconciliation(id, reconciliationDTO);
        return ResponseEntity.ok(updatedReconciliation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReconciliation(@PathVariable Long id) {
        reconciliationService.deleteReconciliation(id);
        return ResponseEntity.noContent().build();
    }
}