package com.microservices.demo.service;



import java.util.List;

import com.microservices.demo.dto.ReturnDTO;
import com.microservices.demo.dto.ReturnDetailsResponseDTO;

public interface ReturnService {

    ReturnDTO createReturn(ReturnDTO dto);

    ReturnDTO getById(Long id);

    List<ReturnDTO> getAll();

    List<ReturnDTO> getByBatch(Long batchId);

    void deleteById(Long id);

    // ✅ Details API
    ReturnDetailsResponseDTO getReturnDetails(Long id);
}
