package com.microservices.demo.dto;

public class BatchDetailsResponseDTO {

    private BatchDTO batch;
    private ProductDTO product;

    public BatchDetailsResponseDTO() {
    }

    public BatchDetailsResponseDTO(BatchDTO batch, ProductDTO product) {
        this.batch = batch;
        this.product = product;
    }

    public BatchDTO getBatch() {
        return batch;
    }

    public void setBatch(BatchDTO batch) {
        this.batch = batch;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}