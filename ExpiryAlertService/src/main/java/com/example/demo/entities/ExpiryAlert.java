package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expiry_alert")
public class ExpiryAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long alertId;


  @Column( name = "batchId")
    private Long batch;

  @Column( name = "productId")
    private Long product;

    private Integer daysToExpiry; //results in null
    private LocalDateTime generatedAt; //represents both date and time
    private String status;

    // Constructor
    public ExpiryAlert() {}
    
    

    public ExpiryAlert(Long alertId, Long batch, Long product, Integer daysToExpiry, LocalDateTime generatedAt,
			String status) {
		super();
		this.alertId = alertId;
		this.batch = batch;
		this.product = product;
		this.daysToExpiry = daysToExpiry;
		this.generatedAt = generatedAt;
		this.status = status;
	}



	// Getters and setters
    public Long getAlertId() { return alertId; }
    public void setAlertId(Long alertId) { this.alertId = alertId; }

    public Long getBatch() { return batch; }
    public void setBatch(Long batch) { this.batch = batch; }

    public Long getProduct() { return product; }
    public void setProduct(Long product) { this.product = product; }

    public Integer getDaysToExpiry() { return daysToExpiry; }
    public void setDaysToExpiry(Integer daysToExpiry) { this.daysToExpiry = daysToExpiry; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

