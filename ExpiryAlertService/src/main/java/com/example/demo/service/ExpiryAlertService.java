package com.example.demo.service;

import com.example.demo.dto.ExpiryAlertDTO;
import com.example.demo.dto.RequiredResponseDTO;

import java.util.List;

public interface ExpiryAlertService {
    ExpiryAlertDTO save(ExpiryAlertDTO dto);
    List<ExpiryAlertDTO> getAll();
    ExpiryAlertDTO getById(Long id);
    void delete(Long id);
    ExpiryAlertDTO update(ExpiryAlertDTO dto);
	RequiredResponseDTO getExpiryAlertDetails(Long alertId);
   
}
