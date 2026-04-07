package com.example.demo.serviceImpl;

import com.example.demo.DTO.StockCountDTO;
import com.example.demo.entities.StockCount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StockCountRepository;
import com.example.demo.service.StockCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockCountServiceImpl implements StockCountService {

    @Autowired
    private StockCountRepository stockCountRepository;

    @Override
    public StockCountDTO createStockCount(StockCountDTO stockCountDTO) {
        StockCount stockCount = new StockCount();
        stockCount.setLocationId(stockCountDTO.getLocationId());
        stockCount.setProductId(stockCountDTO.getProductId());
        stockCount.setBatchId(stockCountDTO.getBatchId());
        stockCount.setCountedQuantity(stockCountDTO.getCountedQuantity());
        stockCount.setCountedBy(stockCountDTO.getCountedBy());
        stockCount.setCountedAt(stockCountDTO.getCountedAt());
        stockCount.setStatus(stockCountDTO.getStatus());
        stockCount = stockCountRepository.save(stockCount);
        return convertToDTO(stockCount);
    }

    @Override
    public StockCountDTO getStockCountById(Long id) {
        StockCount stockCount = stockCountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("StockCount not found"));
        return convertToDTO(stockCount);
    }

    @Override
    public List<StockCountDTO> getAllStockCounts() {
        return stockCountRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public StockCountDTO updateStockCount(Long id, StockCountDTO stockCountDTO) {
        StockCount stockCount = stockCountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("StockCount not found"));
        stockCount.setLocationId(stockCountDTO.getLocationId());
        stockCount.setProductId(stockCountDTO.getProductId());
        stockCount.setBatchId(stockCountDTO.getBatchId());
        stockCount.setCountedQuantity(stockCountDTO.getCountedQuantity());
        stockCount.setCountedBy(stockCountDTO.getCountedBy());
        stockCount.setCountedAt(stockCountDTO.getCountedAt());
        stockCount.setStatus(stockCountDTO.getStatus());
        stockCount = stockCountRepository.save(stockCount);
        return convertToDTO(stockCount);
    }

    @Override
    public void deleteStockCount(Long id) {
        StockCount stockCount = stockCountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("StockCount not found"));
        stockCountRepository.delete(stockCount);
    }

    private StockCountDTO convertToDTO(StockCount stockCount) {
        StockCountDTO dto = new StockCountDTO();
        dto.setCountId(stockCount.getCountId());
        dto.setLocationId(stockCount.getLocationId());
        dto.setProductId(stockCount.getProductId());
        dto.setBatchId(stockCount.getBatchId());
        dto.setCountedQuantity(stockCount.getCountedQuantity());
        dto.setCountedBy(stockCount.getCountedBy());
        dto.setCountedAt(stockCount.getCountedAt());
        dto.setStatus(stockCount.getStatus());
        return dto;
    }
}