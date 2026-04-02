package com.microservices.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.microservices.demo.dto.DispenseDTO;
import com.microservices.demo.dto.DispenseDetailsResponseDTO;
import com.microservices.demo.dto.RequiredResponseDTO;
import com.microservices.demo.service.DispenseService;

@RestController
@RequestMapping("/api/dispenses")
public class DispenseController {

    @Autowired
    private DispenseService service;

    // ==========================
    // CREATE DISPENSE
    // ==========================

    @PostMapping
    public ResponseEntity<RequiredResponseDTO<DispenseDTO>> createDispense(
            @Validated @RequestBody DispenseDTO dispenseDTO) {

        DispenseDTO created = service.createDispense(dispenseDTO);
        return new ResponseEntity<>(
                new RequiredResponseDTO<>(true, "Dispense created successfully", created),
                HttpStatus.CREATED
        );
    }

    // ==========================
    // READ OPERATIONS
    // ==========================

    @GetMapping
    public ResponseEntity<RequiredResponseDTO<List<DispenseDTO>>> getAllDispenses() {

        List<DispenseDTO> list = service.getAllDispenses();
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Dispense list fetched", list)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequiredResponseDTO<DispenseDTO>> getDispenseById(
            @PathVariable Long id) {

        DispenseDTO dispense = service.getDispenseById(id);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Dispense fetched successfully", dispense)
        );
    }

    // ==========================
    // ✅ DISPENSE DETAILS
    // ==========================

    @GetMapping("/details/{id}")
    public ResponseEntity<RequiredResponseDTO<DispenseDetailsResponseDTO>> getDispenseDetails(
            @PathVariable Long id) {

        DispenseDetailsResponseDTO details = service.getDispenseDetails(id);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(
                        true,
                        "Dispense details with product and batch fetched",
                        details
                )
        );
    }

    // ==========================
    // UPDATE DISPENSE
    // ==========================

    @PutMapping("/{id}")
    public ResponseEntity<RequiredResponseDTO<DispenseDTO>> updateDispense(
            @PathVariable Long id,
            @Validated @RequestBody DispenseDTO dispenseDTO) {

        DispenseDTO updated = service.updateDispense(id, dispenseDTO);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Dispense updated successfully", updated)
        );
    }

    // ==========================
    // DELETE DISPENSE
    // ==========================

    @DeleteMapping("/{id}")
    public ResponseEntity<RequiredResponseDTO<Void>> deleteDispense(
            @PathVariable Long id) {

        service.deleteDispenseById(id);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Dispense deleted successfully", null)
        );
    }

    // ==========================
    // FILTERS
    // ==========================

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<RequiredResponseDTO<List<DispenseDTO>>> getByPatientId(
            @PathVariable String patientId) {

        List<DispenseDTO> data = service.getDispenseByPatientId(patientId);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Dispenses fetched for patient", data)
        );
    }

    @GetMapping("/ward/{wardId}")
    public ResponseEntity<RequiredResponseDTO<List<DispenseDTO>>> getByWardId(
            @PathVariable String wardId) {

        List<DispenseDTO> data = service.getDispenseByWardId(wardId);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Dispenses fetched for ward", data)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<RequiredResponseDTO<List<DispenseDTO>>> getByStatus(
            @PathVariable String status) {

        List<DispenseDTO> data = service.getDispenseByStatus(status);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Dispenses fetched by status", data)
        );
    }

    // ==========================
    // STATUS ACTIONS
    // ==========================

    @PostMapping("/{id}/confirm")
    public ResponseEntity<RequiredResponseDTO<DispenseDTO>> confirmDispense(
            @PathVariable Long id) {

        DispenseDTO confirmed = service.confirmDispense(id);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Dispense confirmed successfully", confirmed)
        );
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<RequiredResponseDTO<DispenseDTO>> cancelDispense(
            @PathVariable Long id,
            @RequestParam(required = false) String reason) {

        DispenseDTO cancelled = service.cancelDispense(id, reason);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Dispense cancelled successfully", cancelled)
        );
    }
}
