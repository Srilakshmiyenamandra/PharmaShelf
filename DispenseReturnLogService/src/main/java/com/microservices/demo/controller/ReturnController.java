package com.microservices.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservices.demo.dto.ReturnDTO;
import com.microservices.demo.dto.ReturnDetailsResponseDTO;
import com.microservices.demo.dto.RequiredResponseDTO;
import com.microservices.demo.service.ReturnService;

@RestController
@RequestMapping("/api/returns")
public class ReturnController {

    @Autowired
    private ReturnService service;

    // ==========================
    // CREATE RETURN
    // ==========================

    @PostMapping
    public ResponseEntity<RequiredResponseDTO<ReturnDTO>> create(
            @RequestBody ReturnDTO dto) {

        ReturnDTO created = service.createReturn(dto);
        return new ResponseEntity<>(
                new RequiredResponseDTO<>(true, "Return created successfully", created),
                HttpStatus.CREATED
        );
    }

    // ==========================
    // GET ALL RETURNS
    // ==========================

    @GetMapping
    public ResponseEntity<RequiredResponseDTO<List<ReturnDTO>>> getAll() {

        List<ReturnDTO> list = service.getAll();
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Returns list fetched", list)
        );
    }

    // ==========================
    // GET RETURN BY ID
    // ==========================

    @GetMapping("/{id}")
    public ResponseEntity<RequiredResponseDTO<ReturnDTO>> getById(
            @PathVariable Long id) {

        ReturnDTO item = service.getById(id);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Return fetched successfully", item)
        );
    }

    // ==========================
    // ✅ RETURN + BATCH DETAILS
    // ==========================

    @GetMapping("/{id}/details")
    public ResponseEntity<RequiredResponseDTO<ReturnDetailsResponseDTO>> getReturnDetails(
            @PathVariable Long id) {

        ReturnDetailsResponseDTO details = service.getReturnDetails(id);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(
                        true,
                        "Return details with batch fetched",
                        details
                )
        );
    }

    // ==========================
    // FILTER BY BATCH
    // ==========================

    @GetMapping("/batch/{batchId}")
    public ResponseEntity<RequiredResponseDTO<List<ReturnDTO>>> getByBatch(
            @PathVariable Long batchId) {

        List<ReturnDTO> data = service.getByBatch(batchId);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Returns by batch fetched", data)
        );
    }

    // ==========================
    // DELETE RETURN
    // ==========================

    @DeleteMapping("/{id}")
    public ResponseEntity<RequiredResponseDTO<Void>> delete(
            @PathVariable Long id) {

        service.deleteById(id);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Return deleted successfully", null)
        );
    }
}