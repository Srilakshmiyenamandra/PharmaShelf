package com.example.demo.DTO;

import java.time.LocalDateTime;

public class StockCountDTO {

    private Long countId;
    private Long locationId;
    private Long productId;
    private Long batchId;
    private Integer countedQuantity;
    private Long countedBy;
    private LocalDateTime countedAt;
    private String status;

    public StockCountDTO() {}

    public StockCountDTO(Long countId, Long locationId, Long productId, Long batchId,
                         Integer countedQuantity, Long countedBy, LocalDateTime countedAt, String status) {
        this.countId = countId;
        this.locationId = locationId;
        this.productId = productId;
        this.batchId = batchId;
        this.countedQuantity = countedQuantity;
        this.countedBy = countedBy;
        this.countedAt = countedAt;
        this.status = status;
    }

    // Getters and Setters
    public Long getCountId() { return countId; }
    public void setCountId(Long countId) { this.countId = countId; }

    public Long getLocationId() { return locationId; }
    public void setLocationId(Long locationId) { this.locationId = locationId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Long getBatchId() { return batchId; }
    public void setBatchId(Long batchId) { this.batchId = batchId; }

    public Integer getCountedQuantity() { return countedQuantity; }
    public void setCountedQuantity(Integer countedQuantity) { this.countedQuantity = countedQuantity; }

    public Long getCountedBy() { return countedBy; }
    public void setCountedBy(Long countedBy) { this.countedBy = countedBy; }

    public LocalDateTime getCountedAt() { return countedAt; }
    public void setCountedAt(LocalDateTime countedAt) { this.countedAt = countedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
