package com.microservices.demo.service;

import java.util.List;

import com.microservices.demo.dto.DispenseDTO;

import com.microservices.demo.dto.DispenseDetailsResponseDTO;

public interface DispenseService {

    DispenseDTO createDispense(DispenseDTO dispenseDTO);

    DispenseDTO getDispenseById(Long id);

    List<DispenseDTO> getAllDispenses();

    DispenseDTO updateDispense(Long id, DispenseDTO dispenseDTO);

    void deleteDispenseById(Long id);

    List<DispenseDTO> getDispenseByPatientId(String patientId);

    List<DispenseDTO> getDispenseByWardId(String wardId);

    List<DispenseDTO> getDispenseByStatus(String status);

    DispenseDTO confirmDispense(Long id);

    DispenseDTO cancelDispense(Long id, String reason);


    DispenseDetailsResponseDTO getDispenseDetails(Long id);
}
