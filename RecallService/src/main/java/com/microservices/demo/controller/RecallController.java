package com.microservices.demo.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservices.demo.dto.RecallDTO;
import com.microservices.demo.dto.RecallDetailsResponseDTO;
import com.microservices.demo.service.RecallService;



@RestController
@RequestMapping("/api/recalls")

public class RecallController {

	@Autowired
    private RecallService service;

   

    // ==========================
    // CREATE
    // ==========================

    @PostMapping
    public ResponseEntity<RecallDTO> create(@RequestBody RecallDTO dto) {
        return new ResponseEntity<>(
                service.createRecall(dto),
                HttpStatus.CREATED
        );
    }

    // ==========================
    // READ
    // ==========================

    @GetMapping
    public ResponseEntity<List<RecallDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecallDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // ==========================
    // FILTERS
    // ==========================

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<RecallDTO>> getByProduct(
            @PathVariable Long productId) {
        return ResponseEntity.ok(service.getByProduct(productId));
    }

    @GetMapping("/batch/{batchId}")
    public ResponseEntity<List<RecallDTO>> getByBatch(
            @PathVariable Long batchId) {
        return ResponseEntity.ok(service.getByBatch(batchId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<RecallDTO>> getByStatus(
            @PathVariable String status) {
        return ResponseEntity.ok(service.getByStatus(status));
    }

    @GetMapping("/period")
    public ResponseEntity<List<RecallDTO>> getByPeriod(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return ResponseEntity.ok(service.getByPeriod(from, to));
    }

    // ==========================
    // ✅ DETAILS
    // ==========================

    @GetMapping("/{id}/details")
    public ResponseEntity<RecallDetailsResponseDTO> getDetails(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getRecallDetails(id));
    }

    // ==========================
    // UPDATE
    // ==========================

    @PutMapping("/{id}")
    public ResponseEntity<RecallDTO> update(
            @PathVariable Long id,
            @RequestBody RecallDTO dto) {
        return ResponseEntity.ok(service.updateRecall(id, dto));
    }

    // ==========================
    // DELETE
    // ==========================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}