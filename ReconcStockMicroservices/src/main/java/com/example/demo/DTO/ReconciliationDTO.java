package com.example.demo.DTO;

import java.time.LocalDateTime;

public class ReconciliationDTO {

    private Long reconId;
    private Long countId;
    private Integer expectedQuantity;
    private Integer countedQuantity;
    private Integer variance;
    private Long adjustedBy;
    private LocalDateTime adjustedAt;
    private String status;

    public ReconciliationDTO() {}

    public ReconciliationDTO(Long reconId, Long countId, Integer expectedQuantity,
                             Integer countedQuantity, Integer variance, Long adjustedBy,
                             LocalDateTime adjustedAt, String status) {
        this.reconId = reconId;
        this.countId = countId;
        this.expectedQuantity = expectedQuantity;
        this.countedQuantity = countedQuantity;
        this.variance = variance;
        this.adjustedBy = adjustedBy;
        this.adjustedAt = adjustedAt;
        this.status = status;
    }

    // Getters and Setters
    public Long getReconId() { return reconId; }
    public void setReconId(Long reconId) { this.reconId = reconId; }

    public Long getCountId() { return countId; }
    public void setCountId(Long countId) { this.countId = countId; }

    public Integer getExpectedQuantity() { return expectedQuantity; }
    public void setExpectedQuantity(Integer expectedQuantity) { this.expectedQuantity = expectedQuantity; }

    public Integer getCountedQuantity() { return countedQuantity; }
    public void setCountedQuantity(Integer countedQuantity) { this.countedQuantity = countedQuantity; }

    public Integer getVariance() { return variance; }
    public void setVariance(Integer variance) { this.variance = variance; }

    public Long getAdjustedBy() { return adjustedBy; }
    public void setAdjustedBy(Long adjustedBy) { this.adjustedBy = adjustedBy; }

    public LocalDateTime getAdjustedAt() { return adjustedAt; }
    public void setAdjustedAt(LocalDateTime adjustedAt) { this.adjustedAt = adjustedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
