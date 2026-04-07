package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_counts")
public class StockCount {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long countId;
private Long locationId;
private Long productId;
private Long batchId;
private Integer countedQuantity;
private Long countedBy;
private LocalDateTime countedAt;
private String status;

public StockCount() {}


public StockCount(Long countId, Long locationId, Long productId, Long batchId, Integer countedQuantity, Long countedBy,
		LocalDateTime countedAt, String status) {
	super();
	this.countId = countId;
	this.locationId = locationId;
	this.productId = productId;
	this.batchId = batchId;
	this.countedQuantity = countedQuantity;
	this.countedBy = countedBy;
	this.countedAt = countedAt;
	this.status = status;
}


public Long getCountId() {
	return countId;
}
public void setCountId(Long countId) {
	this.countId = countId;
}
public Long getLocationId() {
	return locationId;
}
public void setLocationId(Long locationId) {
	this.locationId = locationId;
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
public Integer getCountedQuantity() {
	return countedQuantity;
}
public void setCountedQuantity(Integer countedQuantity) {
	this.countedQuantity = countedQuantity;
}
public Long getCountedBy() {
	return countedBy;
}
public void setCountedBy(Long countedBy) {
	this.countedBy = countedBy;
}
public LocalDateTime getCountedAt() {
	return countedAt;
}
public void setCountedAt(LocalDateTime countedAt) {
	this.countedAt = countedAt;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "StockCount [countId=" + countId + ", locationId=" + locationId + ", productId=" + productId + ", batchId="
			+ batchId + ", countedQuantity=" + countedQuantity + ", countedBy=" + countedBy + ", countedAt=" + countedAt
			+ ", status=" + status + "]";
}


}
