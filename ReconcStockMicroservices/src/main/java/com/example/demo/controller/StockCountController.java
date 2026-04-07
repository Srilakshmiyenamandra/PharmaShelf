package com.example.demo.controller;

import com.example.demo.DTO.StockCountDTO;
import com.example.demo.service.StockCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockcounts")
public class StockCountController {

    @Autowired
    private StockCountService stockCountService;

    @PostMapping
    public ResponseEntity<StockCountDTO> createStockCount(@RequestBody StockCountDTO stockCountDTO) {
        StockCountDTO createdStockCount = stockCountService.createStockCount(stockCountDTO);
        return ResponseEntity.ok(createdStockCount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockCountDTO> getStockCountById(@PathVariable Long id) {
        StockCountDTO stockCount = stockCountService.getStockCountById(id);
        return ResponseEntity.ok(stockCount);
    }

    @GetMapping
    public ResponseEntity<List<StockCountDTO>> getAllStockCounts() {
        List<StockCountDTO> stockCounts = stockCountService.getAllStockCounts();
        return ResponseEntity.ok(stockCounts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockCountDTO> updateStockCount(@PathVariable Long id, @RequestBody StockCountDTO stockCountDTO) {
        StockCountDTO updatedStockCount = stockCountService.updateStockCount(id, stockCountDTO);
        return ResponseEntity.ok(updatedStockCount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockCount(@PathVariable Long id) {
        stockCountService.deleteStockCount(id);
        return ResponseEntity.noContent().build();
    }
}