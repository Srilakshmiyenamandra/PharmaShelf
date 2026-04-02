package com.microservices.demo.dto;



public class RecallDetailsResponseDTO {

    private RecallDTO recall;
    private ProductDTO product;
    private BatchDTO batch;

    public RecallDetailsResponseDTO() {
    }

    public RecallDetailsResponseDTO(
            RecallDTO recall,
            ProductDTO product,
            BatchDTO batch) {
        this.recall = recall;
        this.product = product;
        this.batch = batch;
    }

    // ==========================
    // GETTERS & SETTERS
    // ==========================

    public RecallDTO getRecall() {
        return recall;
    }

    public void setRecall(RecallDTO recall) {
        this.recall = recall;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public BatchDTO getBatch() {
        return batch;
    }

    public void setBatch(BatchDTO batch) {
        this.batch = batch;
    }
}