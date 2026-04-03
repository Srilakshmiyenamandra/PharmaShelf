package com.example.demo.module42.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.module42.dto.BatchDTO;
import com.example.demo.module42.dto.ProductDTO;
import com.example.demo.module42.entity.Batch;
import com.example.demo.module42.entity.Product;
import com.example.demo.module42.exception.BadRequestException;
import com.example.demo.module42.exception.ResourceNotFoundException;
import com.example.demo.module42.repository.BatchRepository;
import com.example.demo.module42.repository.ProductRepository;
import com.example.demo.module42.service.ProductBatchService;

@Service
public class ProductBatchServiceImpl implements ProductBatchService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BatchRepository batchRepository;

    // ============================
    // PRODUCT OPERATIONS
    // ============================

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertProductToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        if (id == null) {
            throw new BadRequestException("Product ID cannot be null");
        }

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + id));

        return convertProductToDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        if (dto == null || dto.getName() == null || dto.getName().isEmpty()) {
            throw new BadRequestException("Product name cannot be null or empty");
        }

        Product product = convertProductToEntity(dto);
        Product saved = productRepository.save(product);
        return convertProductToDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        if (id == null) {
            throw new BadRequestException("Product ID cannot be null");
        }

        Product existing = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + id));

        if (dto.getSku() != null) existing.setSku(dto.getSku());
        if (dto.getName() != null) existing.setName(dto.getName());
        if (dto.getGenericName() != null) existing.setGenericName(dto.getGenericName());
        if (dto.getFormulation() != null) existing.setFormulation(dto.getFormulation());
        if (dto.getStrength() != null) existing.setStrength(dto.getStrength());
        if (dto.getUom() != null) existing.setUom(dto.getUom());
        if (dto.getStorageCondition() != null) existing.setStorageCondition(dto.getStorageCondition());
        if (dto.getStatus() != null) existing.setStatus(dto.getStatus());

        Product updated = productRepository.save(existing);
        return convertProductToDTO(updated);
    }

    @Override
    public void deleteProduct(Long id) {
        if (id == null) {
            throw new BadRequestException("Product ID cannot be null");
        }

        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }

        productRepository.deleteById(id);
    }

    // ============================
    // BATCH OPERATIONS
    // ============================

    @Override
    public List<BatchDTO> getAllBatches() {
        return batchRepository.findAll()
                .stream()
                .map(this::convertBatchToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BatchDTO getBatchById(Long id) {
        if (id == null) {
            throw new BadRequestException("Batch ID cannot be null");
        }

        Batch batch = batchRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Batch not found with id: " + id));

        return convertBatchToDTO(batch);
    }

    @Override
    public BatchDTO createBatch(BatchDTO dto) {
        if (dto == null || dto.getProductId() == null) {
            throw new BadRequestException("Product ID is required to create batch");
        }

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + dto.getProductId()));

        Batch batch = convertBatchToEntity(dto);
        batch.setProduct(product); // ✅ Parent assignment

        Batch saved = batchRepository.save(batch);
        return convertBatchToDTO(saved);
    }

    @Override
    public BatchDTO updateBatch(Long id, BatchDTO dto) {
        if (id == null) {
            throw new BadRequestException("Batch ID cannot be null");
        }

        Batch existing = batchRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Batch not found with id: " + id));

        if (dto.getProductId() != null) {
            Product product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Product not found with id: " + dto.getProductId()));
            existing.setProduct(product);
        }

        if (dto.getLotNumber() != null) existing.setLotNumber(dto.getLotNumber());
        if (dto.getManufacturer() != null) existing.setManufacturer(dto.getManufacturer());
        if (dto.getManufactureDate() != null) existing.setManufactureDate(dto.getManufactureDate());
        if (dto.getExpiryDate() != null) existing.setExpiryDate(dto.getExpiryDate());
        if (dto.getQuantityReceived() != null) existing.setQuantityReceived(dto.getQuantityReceived());
        if (dto.getQuantityAvailable() != null) existing.setQuantityAvailable(dto.getQuantityAvailable());
        if (dto.getLocationId() != null) existing.setLocationId(dto.getLocationId());
        if (dto.getStatus() != null) existing.setStatus(dto.getStatus());

        Batch updated = batchRepository.save(existing);
        return convertBatchToDTO(updated);
    }

    @Override
    public void deleteBatch(Long id) {
        if (id == null) {
            throw new BadRequestException("Batch ID cannot be null");
        }

        if (!batchRepository.existsById(id)) {
            throw new ResourceNotFoundException("Batch not found with id: " + id);
        }

        batchRepository.deleteById(id);
    }

    @Override
    public List<BatchDTO> getBatchesByProduct(Long productId) {
        if (productId == null) {
            throw new BadRequestException("Product ID cannot be null");
        }

        return batchRepository.findByProduct_ProductId(productId)
                .stream()
                .map(this::convertBatchToDTO)
                .collect(Collectors.toList());
    }

    // ============================
    // CONVERTERS
    // ============================

    private ProductDTO convertProductToDTO(Product product) {
        return new ProductDTO(
                product.getProductId(),
                product.getSku(),
                product.getName(),
                product.getGenericName(),
                product.getFormulation(),
                product.getStrength(),
                product.getUom(),
                product.getStorageCondition(),
                product.getStatus()
        );
    }

    private Product convertProductToEntity(ProductDTO dto) {
        return new Product(
                dto.getProductId(),
                dto.getSku(),
                dto.getName(),
                dto.getGenericName(),
                dto.getFormulation(),
                dto.getStrength(),
                dto.getUom(),
                dto.getStorageCondition(),
                dto.getStatus()
        );
    }

    private BatchDTO convertBatchToDTO(Batch batch) {

        Product product = batch.getProduct();
        ProductDTO productDTO = convertProductToDTO(product);

        return new BatchDTO(
                batch.getBatchId(),
                product.getProductId(),
                productDTO,                 // ✅ full product details
                batch.getLotNumber(),
                batch.getManufacturer(),
                batch.getManufactureDate(),
                batch.getExpiryDate(),
                batch.getQuantityReceived(),
                batch.getQuantityAvailable(),
                batch.getLocationId(),
                batch.getStatus()
        );
    }

    private Batch convertBatchToEntity(BatchDTO dto) {
        Batch batch = new Batch();
        batch.setLotNumber(dto.getLotNumber());
        batch.setManufacturer(dto.getManufacturer());
        batch.setManufactureDate(dto.getManufactureDate());
        batch.setExpiryDate(dto.getExpiryDate());
        batch.setQuantityReceived(dto.getQuantityReceived());
        batch.setQuantityAvailable(dto.getQuantityAvailable());
        batch.setLocationId(dto.getLocationId());
        batch.setStatus(dto.getStatus());
        return batch;
    }
}