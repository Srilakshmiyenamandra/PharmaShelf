package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuditLogDTO;
import com.example.demo.entity.AuditLog; 
import com.example.demo.repository.AuditLogRepository;
import com.example.demo.service.AuditLogService;

@Service 
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepo;

	@Override
	public AuditLogDTO saveAudit(AuditLogDTO logDTO) {
		
		// 1. Transferring data from DTO to Entity
		AuditLog log = new AuditLog();
		log.setUserID(logDTO.getUserID());
		log.setAction(logDTO.getAction());
		log.setResource(logDTO.getResource());
		log.setResourceID(logDTO.getResourceID());
		log.setTimestamp(logDTO.getTimestamp());
		log.setDetails(logDTO.getDetails());
		
		// 2. Save the entity to the database
		// PharmaShelf requires these to be "immutable transaction trails"
		AuditLog savedLog = auditLogRepo.save(log);
		
		// 3. Transferring data from Entity back to DTO for the return object
		AuditLogDTO cdto = new AuditLogDTO();
		cdto.setAuditID(savedLog.getAuditID());
		cdto.setUserID(savedLog.getUserID());
		cdto.setAction(savedLog.getAction());
		cdto.setResource(savedLog.getResource());
		cdto.setResourceID(savedLog.getResourceID());
		cdto.setTimestamp(savedLog.getTimestamp());
		cdto.setDetails(savedLog.getDetails());
		
		return cdto;
	}

	@Override
	public List<AuditLogDTO> getAll() {
		// Fetching all logs
		List<AuditLog> allLogs = auditLogRepo.findAll();
		
		List<AuditLogDTO> allLogsDTO = new ArrayList<>();
		for (AuditLog log : allLogs) {
			AuditLogDTO dto = new AuditLogDTO();
			dto.setAuditID(log.getAuditID());
			dto.setUserID(log.getUserID());
			dto.setAction(log.getAction());
			dto.setResource(log.getResource());
			dto.setResourceID(log.getResourceID());
			dto.setTimestamp(log.getTimestamp());
			dto.setDetails(log.getDetails());
			allLogsDTO.add(dto);
		}
		
		return allLogsDTO;
	}
}