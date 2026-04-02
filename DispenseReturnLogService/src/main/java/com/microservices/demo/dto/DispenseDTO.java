package com.microservices.demo.dto;

import java.time.LocalDateTime;

public class DispenseDTO {

    private Long dispenseId;
    private Long batchId;
    private Long productId;
    private String patientId;
    private String wardId;
    private Integer quantity;
    private LocalDateTime dispensedAt;
    private String dispensedBy;
    

    // getters & setters
    public Long getDispenseId() {
		return dispenseId;
	}
	public void setDispenseId(Long dispenseId) {
		this.dispenseId = dispenseId;
	}
	public Long getBatchId() {
		return batchId;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getWardId() {
		return wardId;
	}
	public void setWardId(String wardId) {
		this.wardId = wardId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getDispensedAt() {
		return dispensedAt;
	}
	public void setDispensedAt(LocalDateTime dispensedAt) {
		this.dispensedAt = dispensedAt;
	}
	public String getDispensedBy() {
		return dispensedBy;
	}
	public void setDispensedBy(String dispensedBy) {
		this.dispensedBy = dispensedBy;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String purpose;
    private String status;

}