package com.microservices.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservices.demo.dto.ProductDTO;
import com.microservices.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ==========================
    // CREATE PRODUCT
    // ==========================

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(
            @RequestBody ProductDTO productDTO) {

        ProductDTO saved = productService.save(productDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ==========================
    // GET ALL PRODUCTS
    // ==========================

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {

        List<ProductDTO> products = productService.getAll();
        return ResponseEntity.ok(products);
    }

    // ==========================
    // GET PRODUCT BY ID
    // ==========================

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductDTO> getProductById(
            @PathVariable Long id) {

        ProductDTO product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    // ==========================
    // UPDATE PRODUCT
    // ==========================

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO) {

        ProductDTO updated = productService.update(id, productDTO);
        return ResponseEntity.ok(updated);
    }

    // ==========================
    // DELETE PRODUCT
    // ==========================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {

        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}