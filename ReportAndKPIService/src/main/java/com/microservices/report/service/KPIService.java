package com.microservices.report.service;

import com.microservices.report.dto.KpiDTO;
import java.util.List;

public interface KPIService {
    KpiDTO save(KpiDTO dto);
    List<KpiDTO> getAll();
    KpiDTO getById(Long id);
    void delete(Long id);
    KpiDTO update(KpiDTO dto);
}
