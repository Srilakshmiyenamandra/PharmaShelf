package com.example.demo.module42.service;

import java.util.List;

import com.example.demo.module42.dto.ProductDTO;
import com.example.demo.module42.dto.BatchDTO;

/**
 * Unified facade service for Module 4.2 (Product Master & Batch Management).
 * Coordinates Product and Batch operations with centralized error handling.
 */
public interface ProductBatchService {

    // ====== PRODUCT OPERATIONS ======
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);

    // ====== BATCH OPERATIONS ======
    List<BatchDTO> getAllBatches();
    BatchDTO getBatchById(Long id);
    BatchDTO createBatch(BatchDTO batchDTO);
    BatchDTO updateBatch(Long id, BatchDTO batchDTO);
    void deleteBatch(Long id);
    List<BatchDTO> getBatchesByProduct(Long productId);
}
