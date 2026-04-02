package com.microservices.demo.serviceimpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.microservices.demo.dto.ProductDTO;
import com.microservices.demo.entity.Product;
import com.microservices.demo.repository.ProductRepository;
import com.microservices.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    // ==========================
    // CREATE
    // ==========================

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapToEntity(productDTO);
        Product saved = repo.save(product);
        return mapToDTO(saved);
    }

    // ==========================
    // READ
    // ==========================

    @Override
    public List<ProductDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Long id) {
        return repo.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    // ==========================
    // UPDATE
    // ==========================

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {

        Product product = repo.findById(id).orElse(null);
        if (product == null) {
            return null;
        }

        product.setSku(productDTO.getSku());
        product.setName(productDTO.getName());
        product.setGenericName(productDTO.getGenericName());
        product.setFormulation(productDTO.getFormulation());
        product.setStrength(productDTO.getStrength());
        product.setUom(productDTO.getUom());
        product.setStorageCondition(productDTO.getStorageCondition());
        product.setStatus(productDTO.getStatus());

        Product updated = repo.save(product);
        return mapToDTO(updated);
    }

    // ==========================
    // DELETE
    // ==========================

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // ==========================
    // MAPPERS
    // ==========================

    private ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setSku(product.getSku());
        dto.setName(product.getName());
        dto.setGenericName(product.getGenericName());
        dto.setFormulation(product.getFormulation());
        dto.setStrength(product.getStrength());
        dto.setUom(product.getUom());
        dto.setStorageCondition(product.getStorageCondition());
        dto.setStatus(product.getStatus());
        return dto;
    }

    private Product mapToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setSku(dto.getSku());
        product.setName(dto.getName());
        product.setGenericName(dto.getGenericName());
        product.setFormulation(dto.getFormulation());
        product.setStrength(dto.getStrength());
        product.setUom(dto.getUom());
        product.setStorageCondition(dto.getStorageCondition());
        product.setStatus(dto.getStatus());
        return product;
    }
}