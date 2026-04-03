package com.microservices.report.serviceImpl;

import com.microservices.report.dto.KpiDTO;
import com.microservices.report.entities.KPI;
import com.microservices.report.exception.ResourceNotFoundException;
import com.microservices.report.repository.KPIRepo;
import com.microservices.report.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KPIServiceImpl implements KPIService {

    @Autowired
    private KPIRepo kpiRepo;

    // Convert DTO → Entity
    private KPI convertToEntity(KpiDTO dto) {
        if (dto == null) {
            return null;
        }
        KPI kpi = new KPI();
        kpi.setKpiId(dto.getKpiId());
        kpi.setName(dto.getName());
        kpi.setDefinition(dto.getDefinition());
        kpi.setTarget(dto.getTarget());
        kpi.setCurrentValue(dto.getCurrentValue());
        kpi.setReportingPeriod(dto.getReportingPeriod());
        return kpi;
    }

    // Convert Entity → DTO
    private KpiDTO convertToDTO(KPI kpi) {
        if (kpi == null) {
            return null;
        }
        KpiDTO dto = new KpiDTO();
        dto.setKpiId(kpi.getKpiId());
        dto.setName(kpi.getName());
        dto.setDefinition(kpi.getDefinition());
        dto.setTarget(kpi.getTarget());
        dto.setCurrentValue(kpi.getCurrentValue());
        dto.setReportingPeriod(kpi.getReportingPeriod());
        return dto;
    }

    @Override
    public KpiDTO save(KpiDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("KPI data must not be null");
        }
        KPI saved = kpiRepo.save(convertToEntity(dto));
        return convertToDTO(saved);
    }

    @Override
    public List<KpiDTO> getAll() {
        return kpiRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public KpiDTO getById(Long id) {
        KPI kpi = kpiRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("KPI not found with id: " + id));
        return convertToDTO(kpi);
    }

    @Override
    public void delete(Long id) {
        if (!kpiRepo.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete. KPI not found with id: " + id);
        }
        kpiRepo.deleteById(id);
    }

    @Override
    public KpiDTO update(KpiDTO dto) {
        if (dto == null || dto.getKpiId() == null) {
            throw new IllegalArgumentException("KPI id and data must not be null");
        }
        if (!kpiRepo.existsById(dto.getKpiId())) {
            throw new ResourceNotFoundException("Cannot update. KPI not found with id: " + dto.getKpiId());
        }
        KPI updated = kpiRepo.save(convertToEntity(dto));
        return convertToDTO(updated);
    }
}
