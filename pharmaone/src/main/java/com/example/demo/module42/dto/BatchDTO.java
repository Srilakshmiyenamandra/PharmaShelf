package com.example.demo.module42.dto;

import java.time.LocalDate;

public class BatchDTO {

    private Long batchId;

    // Used in request (POST / PUT)
    private Long productId;

    // Used in response (GET)
    private ProductDTO product;

    private String lotNumber;
    private String manufacturer;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private Integer quantityReceived;
    private Integer quantityAvailable;
    private Long locationId;
    private String status;

    public BatchDTO() {
    }

    public BatchDTO(Long batchId, Long productId, ProductDTO product,
                    String lotNumber, String manufacturer,
                    LocalDate manufactureDate, LocalDate expiryDate,
                    Integer quantityReceived, Integer quantityAvailable,
                    Long locationId, String status) {

        this.batchId = batchId;
        this.productId = productId;
        this.product = product;
        this.lotNumber = lotNumber;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.quantityReceived = quantityReceived;
        this.quantityAvailable = quantityAvailable;
        this.locationId = locationId;
        this.status = status;
    }

    // ---------------- GETTERS ----------------

    public Long getBatchId() {
        return batchId;
    }

    public Long getProductId() {
        return productId;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public Integer getQuantityReceived() {
        return quantityReceived;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public Long getLocationId() {
        return locationId;
    }

    public String getStatus() {
        return status;
    }

    // ---------------- SETTERS ----------------

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setQuantityReceived(Integer quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ---------------- toString ----------------

    @Override
    public String toString() {
        return "BatchDTO{" +
                "batchId=" + batchId +
                ", productId=" + productId +
                ", product=" + product +
                ", lotNumber='" + lotNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", expiryDate=" + expiryDate +
                ", quantityReceived=" + quantityReceived +
                ", quantityAvailable=" + quantityAvailable +
                ", locationId=" + locationId +
                ", status='" + status + '\'' +
                '}';
    }
}
