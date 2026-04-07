package com.example.demo.service;

import com.example.demo.DTO.StockCountDTO;
import java.util.List;

public interface StockCountService {
    StockCountDTO createStockCount(StockCountDTO stockCountDTO);
    StockCountDTO getStockCountById(Long id);
    List<StockCountDTO> getAllStockCounts();
    StockCountDTO updateStockCount(Long id, StockCountDTO stockCountDTO);
    void deleteStockCount(Long id);
}