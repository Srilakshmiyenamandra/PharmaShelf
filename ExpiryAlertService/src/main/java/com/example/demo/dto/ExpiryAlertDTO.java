package com.example.demo.dto;

import java.time.LocalDateTime;

public class ExpiryAlertDTO {

    private Long alertId;
    private Long batchId;
    private Long productId;
    private Integer daysToExpiry;
    private LocalDateTime generatedAt;
    private String status;

    // Default constructor
    public ExpiryAlertDTO() {}

    // Parameterized constructor
    public ExpiryAlertDTO(Long alertId, Long batchId, Long productId, Integer daysToExpiry,
                          LocalDateTime generatedAt, String status) {
        this.alertId = alertId;
        this.batchId = batchId;
        this.productId = productId;
        this.daysToExpiry = daysToExpiry;
        this.generatedAt = generatedAt;
        this.status = status;
    }

    // Getters and setters
    public Long getAlertId() { return alertId; }
    public void setAlertId(Long alertId) { this.alertId = alertId; }

    public Long getBatchId() { return batchId; }
    public void setBatchId(Long batchId) { this.batchId = batchId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Integer getDaysToExpiry() { return daysToExpiry; }
    public void setDaysToExpiry(Integer daysToExpiry) { this.daysToExpiry = daysToExpiry; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
