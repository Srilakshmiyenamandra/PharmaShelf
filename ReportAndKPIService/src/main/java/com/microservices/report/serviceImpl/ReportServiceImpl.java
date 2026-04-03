package com.microservices.report.serviceImpl;

import com.microservices.report.dto.ReportDTO;
import com.microservices.report.entities.Report;
import com.microservices.report.exception.ResourceNotFoundException;
import com.microservices.report.repository.ReportRepo;
import com.microservices.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepo reportRepo;

    private Report convertToEntity(ReportDTO dto) {
        if (dto == null) {
            return null;
        }
        Report report = new Report();
        report.setReportId(dto.getReportId());
        report.setScope(dto.getScope());
        report.setParametersJSON(dto.getParametersJSON());
        report.setGeneratedBy(dto.getGeneratedBy());
        report.setGeneratedAt(dto.getGeneratedAt());
        report.setReportURI(dto.getReportURI());
        return report;
    }

    private ReportDTO convertToDTO(Report report) {
        if (report == null) {
            return null;
        }
        ReportDTO dto = new ReportDTO();
        dto.setReportId(report.getReportId());
        dto.setScope(report.getScope());
        dto.setParametersJSON(report.getParametersJSON());
        dto.setGeneratedBy(report.getGeneratedBy());
        dto.setGeneratedAt(report.getGeneratedAt());
        dto.setReportURI(report.getReportURI());
        return dto;
    }

    @Override
    public ReportDTO save(ReportDTO reportDto) {
        if (reportDto == null) {
            throw new IllegalArgumentException("Report data must not be null");
        }
        Report report = convertToEntity(reportDto);
        Report saved = reportRepo.save(report);
        return convertToDTO(saved);
    }

    @Override
    public List<ReportDTO> getAll() {
        return reportRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReportDTO getById(Long id) {
        Report report = reportRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with id: " + id));
        return convertToDTO(report);
    }

    @Override
    public void delete(Long id) {
        if (!reportRepo.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete. Report not found with id: " + id);
        }
        reportRepo.deleteById(id);
    }

    @Override
    public ReportDTO updateReport(ReportDTO reportDto) {
        if (reportDto == null || reportDto.getReportId() == null) {
            throw new IllegalArgumentException("Report id and data must not be null");
        }
        if (!reportRepo.existsById(reportDto.getReportId())) {
            throw new ResourceNotFoundException("Cannot update. Report not found with id: " + reportDto.getReportId());
        }
        Report report = convertToEntity(reportDto);
        Report updated = reportRepo.save(report);
        return convertToDTO(updated);
    }


}
