package com.microservices.demo.dto;

import java.time.LocalDate;

public class ReturnDTO {

    private Long returnId;
    private Long batchId;
    private Long dispenseId;
    private String reason;
    private LocalDate returnedAt;
    private String returnedBy;
    private double quantity;
    private String status;
	public Long getReturnId() {
		return returnId;
	}
	public void setReturnId(Long returnId) {
		this.returnId = returnId;
	}
	public Long getBatchId() {
		return batchId;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	public Long getDispenseId() {
		return dispenseId;
	}
	public void setDispenseId(Long dispenseId) {
		this.dispenseId = dispenseId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LocalDate getReturnedAt() {
		return returnedAt;
	}
	public void setReturnedAt(LocalDate returnedAt) {
		this.returnedAt = returnedAt;
	}
	public String getReturnedBy() {
		return returnedBy;
	}
	public void setReturnedBy(String returnedBy) {
		this.returnedBy = returnedBy;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}