package com.microservices.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long productId;

@Column(nullable=false, unique=true)
private String sku;

@Column(nullable=false)
private String name;

private String genericName;

private String formulation;

private String strength;

private String uom;

private String storageCondition;

private String status;

public Product() {}

public Long getProductId() {
return productId;
}

public void setProductId(Long productId) {
this.productId = productId;
}

public String getSku() {
return sku;
}

public void setSku(String sku) {
this.sku = sku;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getGenericName() {
return genericName;
}

public void setGenericName(String genericName) {
this.genericName = genericName;
}

public String getFormulation() {
return formulation;
}

public void setFormulation(String formulation) {
this.formulation = formulation;
}

public String getStrength() {
return strength;
}

public void setStrength(String strength) {
this.strength = strength;
}

public String getUom() {
return uom;
}

public void setUom(String uom) {
this.uom = uom;
}

public String getStorageCondition() {
return storageCondition;
}

public void setStorageCondition(String storageCondition) {
this.storageCondition = storageCondition;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

}