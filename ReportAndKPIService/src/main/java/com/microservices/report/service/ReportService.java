package com.microservices.report.service;

import com.microservices.report.dto.ReportDTO;

import java.util.List;


import com.microservices.report.entities.Report;


public interface ReportService {
    ReportDTO save(ReportDTO reportDto);
    List<ReportDTO> getAll();
    ReportDTO getById(Long id);
    void delete(Long id);
    ReportDTO updateReport(ReportDTO reportDto);
}
