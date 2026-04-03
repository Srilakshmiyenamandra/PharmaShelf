package com.example.demo.module42.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module42.dto.BatchDTO;
import com.example.demo.module42.service.ProductBatchService;

@RestController
@RequestMapping("/api/v1/module42/batches")
public class BatchController {

    @Autowired
    private ProductBatchService service;

    @PostMapping
    public ResponseEntity<BatchDTO> createBatch(@RequestBody BatchDTO batchDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createBatch(batchDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchDTO> getBatchById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBatchById(id));
    }

    @GetMapping
    public ResponseEntity<List<BatchDTO>> getAllBatches() {
        return ResponseEntity.ok(service.getAllBatches());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<BatchDTO>> getBatchesByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(service.getBatchesByProduct(productId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BatchDTO> updateBatch(@PathVariable Long id, @RequestBody BatchDTO batchDTO) {
        return ResponseEntity.ok(service.updateBatch(id, batchDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatch(@PathVariable Long id) {
        service.deleteBatch(id);
        return ResponseEntity.noContent().build();
    }
}
