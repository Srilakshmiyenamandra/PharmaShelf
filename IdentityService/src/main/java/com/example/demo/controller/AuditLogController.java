package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AuditLogDTO;
import com.example.demo.service.AuditLogService;

@RestController
@RequestMapping("/audit")
public class AuditLogController {

    @Autowired
    private AuditLogService auditService;

    // CREATE: Record a new audit log
    @PostMapping
    @PreAuthorize("hasRole('AUDITOR')")
    public ResponseEntity<AuditLogDTO> create(@RequestBody AuditLogDTO logDTO) {
        AuditLogDTO savedLog = auditService.saveAudit(logDTO);
        return new ResponseEntity<>(savedLog, HttpStatus.OK);
    }

    // READ: Get all audit logs
    @GetMapping
    @PreAuthorize("hasRole('AUDITOR')")
    public ResponseEntity<List<AuditLogDTO>> getAll() {
        List<AuditLogDTO> allLogs = auditService.getAll();
        return new ResponseEntity<>(allLogs, HttpStatus.OK);
    }
}