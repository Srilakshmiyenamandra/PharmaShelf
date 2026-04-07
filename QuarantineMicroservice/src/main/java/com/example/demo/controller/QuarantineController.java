package com.example.demo.controller;

import com.example.demo.DTO.QuarantineDTO;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.service.QuarantineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quarantines")
public class QuarantineController {

    private final QuarantineService service;

    public QuarantineController(QuarantineService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<QuarantineDTO> createQuarantine(@RequestBody QuarantineDTO dto) {
        QuarantineDTO savedQuarantine = service.createQuarantine(dto);
        return ResponseEntity.ok(savedQuarantine);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getQuarantineById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getQuarantineById(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getAllQuarantines() {
        return ResponseEntity.ok(service.getAllQuarantines());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateQuarantine(@PathVariable Long id, @RequestBody QuarantineDTO dto) {
        return ResponseEntity.ok(service.updateQuarantine(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuarantine(@PathVariable Long id) {
        service.deleteQuarantine(id);
        return ResponseEntity.noContent().build();
    }
}
