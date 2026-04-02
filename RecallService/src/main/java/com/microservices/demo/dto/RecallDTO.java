package com.microservices.demo.dto;



import java.time.LocalDate;

public class RecallDTO {

    private Long recallId;

    // ✅ ID-only references (important for microservices)
    private Long productId;
    private Long batchId;

    private String reason;
    private LocalDate recalledAt;
    private String recalledBy;
    private Double quantity;
    private String status;

    public RecallDTO() {
    }

    // ==========================
    // GETTERS & SETTERS
    // ==========================

    public Long getRecallId() {
        return recallId;
    }

    public void setRecallId(Long recallId) {
        this.recallId = recallId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getRecalledAt() {
        return recalledAt;
    }

    public void setRecalledAt(LocalDate recalledAt) {
        this.recalledAt = recalledAt;
    }

    public String getRecalledBy() {
        return recalledBy;
    }

    public void setRecalledBy(String recalledBy) {
        this.recalledBy = recalledBy;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}