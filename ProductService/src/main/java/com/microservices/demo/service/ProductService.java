package com.microservices.demo.service;


import java.util.List;
import com.microservices.demo.dto.ProductDTO;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> getAll();

    ProductDTO getById(Long id);

    ProductDTO update(Long id, ProductDTO productDTO);

    void delete(Long id);
}