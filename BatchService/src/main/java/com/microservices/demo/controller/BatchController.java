package com.microservices.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservices.demo.dto.BatchDTO;
import com.microservices.demo.dto.BatchDetailsResponseDTO;
import com.microservices.demo.service.BatchService;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    // ==========================
    // CREATE / UPDATE
    // ==========================

    @PostMapping
    public ResponseEntity<BatchDTO> saveBatch(@RequestBody BatchDTO batchDTO) {
        BatchDTO saved = batchService.save(batchDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ==========================
    // GET ALL
    // ==========================

    @GetMapping
    public ResponseEntity<List<BatchDTO>> getAllBatches() {
        return ResponseEntity.ok(batchService.getAll());
    }

    // ==========================
    // GET BY ID
    // ==========================

    @GetMapping("/{id}")
    public ResponseEntity<BatchDTO> getBatchById(@PathVariable Long id) {
        return ResponseEntity.ok(batchService.getById(id));
    }

    // ==========================
    // GET BY PRODUCT
    // ==========================

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<BatchDTO>> getBatchesByProduct(
            @PathVariable Long productId) {

        return ResponseEntity.ok(batchService.getByProduct(productId));
    }

    // ==========================
    // ✅ BATCH + PRODUCT DETAILS
    // ==========================

    @GetMapping("/{id}/details")
    public ResponseEntity<BatchDetailsResponseDTO> getBatchDetails(
            @PathVariable Long id) {

        return ResponseEntity.ok(batchService.getBatchDetails(id));
    }

    // ==========================
    // DELETE
    // ==========================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatch(@PathVariable Long id) {
        batchService.delete(id);
        return ResponseEntity.noContent().build();
    }
}