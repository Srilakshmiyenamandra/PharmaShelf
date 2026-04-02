package com.microservices.demo.service;



import java.time.LocalDate;
import java.util.List;

import com.microservices.demo.dto.RecallDTO;
import com.microservices.demo.dto.RecallDetailsResponseDTO;



public interface RecallService {

    // ==========================
    // CREATE / UPDATE
    // ==========================

    RecallDTO createRecall(RecallDTO recallDTO);

    RecallDTO updateRecall(Long recallId, RecallDTO recallDTO);

    // ==========================
    // READ
    // ==========================

    RecallDTO getById(Long recallId);

    List<RecallDTO> getAll();

    // ==========================
    // FILTERS
    // ==========================

    List<RecallDTO> getByProduct(Long productId);

    List<RecallDTO> getByBatch(Long batchId);

    List<RecallDTO> getByStatus(String status);

    List<RecallDTO> getByPeriod(LocalDate from, LocalDate to);

    // ==========================
    // VALIDATION / SAFETY
    // ==========================

    boolean isProductRecalled(Long productId);

    boolean isBatchRecalled(Long batchId);

    // ==========================
    // ✅ DETAILS (Recall + Product + Batch)
    // ==========================

    RecallDetailsResponseDTO getRecallDetails(Long recallId);

    // ==========================
    // DELETE
    // ==========================

    void deleteById(Long recallId);
}