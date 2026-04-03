package com.example.demo.dto;

public class RequiredResponseDTO {

    private ExpiryAlertDTO alertDto;
    private ProductDTO product;
    private BatchDTO batch;

    // ==========================
    // Getters & Setters
    // ==========================

    public ExpiryAlertDTO getAlertDto() {
        return alertDto;
    }

    public void setAlertDto(ExpiryAlertDTO alertDto) {
        this.alertDto = alertDto;
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

    // ==========================
    // Constructors
    // ==========================

    public RequiredResponseDTO() {
    }

    public RequiredResponseDTO(ExpiryAlertDTO alertDto, ProductDTO product, BatchDTO batch) {
        this.alertDto = alertDto;
        this.product = product;
        this.batch = batch;
    }

    // ==========================
    // toString (optional, for logging/debugging)
    // ==========================

    @Override
    public String toString() {
        return "RequiredResponseDTO{" +
                "alertDto=" + alertDto +
                ", product=" + product +
                ", batch=" + batch +
                '}';
    }
}
