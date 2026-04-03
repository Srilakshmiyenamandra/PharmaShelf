package com.microservices.report.controller;

import com.microservices.report.dto.KpiDTO;
import com.microservices.report.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kpi")
public class KPIController {

    @Autowired
    private KPIService service;

    @PostMapping("/insert")
    public ResponseEntity<KpiDTO> create(@RequestBody KpiDTO dto) {
        KpiDTO saved = service.save(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<KpiDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<KpiDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<KpiDTO> update(@RequestBody KpiDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }
}
