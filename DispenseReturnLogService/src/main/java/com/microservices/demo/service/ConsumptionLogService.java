package com.microservices.demo.service;


import java.time.LocalDateTime;
import java.util.List;

import com.microservices.demo.dto.ConsumptionLogDTO;
import com.microservices.demo.dto.ConsumptionLogDetailsResponseDTO;

public interface ConsumptionLogService {

    ConsumptionLogDTO insertConsumptionLog(ConsumptionLogDTO dto);

    List<ConsumptionLogDTO> getAll();

    ConsumptionLogDTO getById(Long id);

    List<ConsumptionLogDTO> getByProduct(Long productId);

    List<ConsumptionLogDTO> getByPeriod(LocalDateTime from, LocalDateTime to);

    void delById(long id);

    ConsumptionLogDTO updateLog(ConsumptionLogDTO dto);

  
    ConsumptionLogDetailsResponseDTO getConsumptionLogDetails(Long id);
}