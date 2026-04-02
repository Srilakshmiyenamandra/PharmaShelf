package com.microservices.demo.entity;



import jakarta.persistence.*;


import java.time.LocalDateTime;



@Entity
@Table(name="dispense")
public class Dispense {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dispenseId;

    private Long batch;

    private Long product;
      
    private String patientId;
      
    private String wardId;
    
    private Integer quantity;
    
    private LocalDateTime dispensedAt;
    
    private String dispensedBy;

    private String purpose;
    
    private String status;

    public Dispense() {}
    

	public Dispense(Long dispenseId, Long batch, Long product, String patientId, String wardId, Integer quantity,
			LocalDateTime dispensedAt, String dispensedBy, String purpose, String status) {
		super();
		this.dispenseId = dispenseId;
		this.batch = batch;
		this.product = product;
		this.patientId = patientId;
		this.wardId = wardId;
		this.quantity = quantity;
		this.dispensedAt = dispensedAt;
		this.dispensedBy = dispensedBy;
		this.purpose = purpose;
		this.status = status;
	}
	 

	public Long getDispenseId() {
		return dispenseId;
	}

	public void setDispenseId(Long dispenseId) {
		this.dispenseId = dispenseId;
	}

	public Long getBatch() {
		return batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
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


	@Override
	public String toString() {
		return "Dispense [dispenseId=" + dispenseId + ", batch=" + batch + ", product=" + product + ", patientId="
				+ patientId + ", wardId=" + wardId + ", quantity=" + quantity + ", dispensedAt=" + dispensedAt
				+ ", dispensedBy=" + dispensedBy + ", purpose=" + purpose + ", status=" + status + "]";
	}
	

 
}


