package com.example.demo.service;



import com.example.demo.DTO.QuarantineDTO;
import com.example.demo.DTO.ResponseDTO;
import java.util.List;

public interface QuarantineService {
	public QuarantineDTO createQuarantine(QuarantineDTO quarantineDTO);
    ResponseDTO getQuarantineById(Long id);
    List<ResponseDTO> getAllQuarantines();
    ResponseDTO updateQuarantine(Long id, QuarantineDTO quarantineDTO);
    void deleteQuarantine(Long id);
}
