package com.example.demo.module42.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Long batchId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "lot_number")
    private String lotNumber;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "quantity_received")
    private Integer quantityReceived;

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "status")
    private String status;

    public Batch() {}

    public Batch(Long batchId, Product product, String lotNumber, String manufacturer, LocalDate manufactureDate,
            LocalDate expiryDate, Integer quantityReceived, Integer quantityAvailable, Long locationId, String status) {
        this.batchId = batchId;
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

    public Long getBatchId() { return batchId; }
    public void setBatchId(Long batchId) { this.batchId = batchId; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public String getLotNumber() { return lotNumber; }
    public void setLotNumber(String lotNumber) { this.lotNumber = lotNumber; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public LocalDate getManufactureDate() { return manufactureDate; }
    public void setManufactureDate(LocalDate manufactureDate) { this.manufactureDate = manufactureDate; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public Integer getQuantityReceived() { return quantityReceived; }
    public void setQuantityReceived(Integer quantityReceived) { this.quantityReceived = quantityReceived; }
    public Integer getQuantityAvailable() { return quantityAvailable; }
    public void setQuantityAvailable(Integer quantityAvailable) { this.quantityAvailable = quantityAvailable; }
    public Long getLocationId() { return locationId; }
    public void setLocationId(Long locationId) { this.locationId = locationId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Batch [batchId=" + batchId + ", product=" + product + ", lotNumber=" + lotNumber + ", manufacturer="
                + manufacturer + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate
                + ", quantityReceived=" + quantityReceived + ", quantityAvailable=" + quantityAvailable
                + ", locationId=" + locationId + ", status=" + status + "]";
    }
}
