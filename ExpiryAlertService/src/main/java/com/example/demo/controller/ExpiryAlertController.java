package com.example.demo.controller;

import com.example.demo.dto.ExpiryAlertDTO;
import com.example.demo.dto.RequiredResponseDTO;
import com.example.demo.service.ExpiryAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expiryalerts")
public class ExpiryAlertController {

    @Autowired
    private ExpiryAlertService service;

    // ✅ Create new alert
    @PostMapping("/insert")
    public ResponseEntity<ExpiryAlertDTO> create(@RequestBody ExpiryAlertDTO dto) {
        ExpiryAlertDTO saved = service.save(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ✅ Get all alerts
    @GetMapping("/all")
    public ResponseEntity<List<ExpiryAlertDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // ✅ Get alert by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ExpiryAlertDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // ✅ Delete alert
    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ✅ Update alert
    @PutMapping("/update")
    public ResponseEntity<ExpiryAlertDTO> update(@RequestBody ExpiryAlertDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    // ✅ Get expiry alert details (Alert + Product + Batch)
    @GetMapping("/details/{id}")
    public ResponseEntity<RequiredResponseDTO> getAlertDetails(@PathVariable Long id) {
        return ResponseEntity.ok(service.getExpiryAlertDetails(id));
    }
}
