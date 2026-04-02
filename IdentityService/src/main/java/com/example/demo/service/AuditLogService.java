package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AuditLogDTO;


public interface AuditLogService {
    
    AuditLogDTO saveAudit(AuditLogDTO log);
    
    List<AuditLogDTO> getAll();
}
