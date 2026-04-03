package com.microservices.report.controller;

import com.microservices.report.dto.ReportDTO;
import com.microservices.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService service;

    @PostMapping("/insert")
    public ResponseEntity<ReportDTO> create(@RequestBody ReportDTO reportDto) {
        ReportDTO saved = service.save(reportDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReportDTO>> getAll() {
        List<ReportDTO> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ReportDTO> getById(@PathVariable Long id) {
        ReportDTO report = service.getById(id);
        return ResponseEntity.ok(report);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<ReportDTO> update(@RequestBody ReportDTO reportDto) {
        ReportDTO updated = service.updateReport(reportDto);
        return ResponseEntity.ok(updated);
    }
}
