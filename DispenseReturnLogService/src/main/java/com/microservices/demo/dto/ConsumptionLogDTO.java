package com.microservices.demo.dto;

import java.time.LocalDateTime;

public class ConsumptionLogDTO {

    private Long logId;
    private Long productId;
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
	private Double quantityUsed;
    private LocalDateTime generatedAt;
    public Long getLogId() {
		return logId;
	}
	public void setLogId(Long logId) {
		this.logId = logId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public LocalDateTime getPeriodStart() {
		return periodStart;
	}
	public void setPeriodStart(LocalDateTime periodStart) {
		this.periodStart = periodStart;
	}
	public LocalDateTime getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(LocalDateTime periodEnd) {
		this.periodEnd = periodEnd;
	}
	public Double getQuantityUsed() {
		return quantityUsed;
	}
	public void setQuantityUsed(Double quantityUsed) {
		this.quantityUsed = quantityUsed;
	}
	public LocalDateTime getGeneratedAt() {
		return generatedAt;
	}
	public void setGeneratedAt(LocalDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}


    // getters & setters
}