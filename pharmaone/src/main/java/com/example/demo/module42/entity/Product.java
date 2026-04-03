package com.example.demo.module42.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "sku", nullable = false)
    private String sku;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "generic_name")
    private String genericName;

    @Column(name = "formulation")
    private String formulation;

    @Column(name = "strength")
    private String strength;

    @Column(name = "uom")
    private String uom;

    @Column(name = "storage_condition")
    private String storageCondition;

    @Column(name = "status")
    private String status;

    public Product() {}

    public Product(Long productId, String sku, String name, String genericName, String formulation,
            String strength, String uom, String storageCondition, String status) {
        this.productId = productId;
        this.sku = sku;
        this.name = name;
        this.genericName = genericName;
        this.formulation = formulation;
        this.strength = strength;
        this.uom = uom;
        this.storageCondition = storageCondition;
        this.status = status;
    }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGenericName() { return genericName; }
    public void setGenericName(String genericName) { this.genericName = genericName; }
    public String getFormulation() { return formulation; }
    public void setFormulation(String formulation) { this.formulation = formulation; }
    public String getStrength() { return strength; }
    public void setStrength(String strength) { this.strength = strength; }
    public String getUom() { return uom; }
    public void setUom(String uom) { this.uom = uom; }
    public String getStorageCondition() { return storageCondition; }
    public void setStorageCondition(String storageCondition) { this.storageCondition = storageCondition; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", sku=" + sku + ", name=" + name + ", genericName="
                + genericName + ", formulation=" + formulation + ", strength=" + strength + ", uom=" + uom
                + ", storageCondition=" + storageCondition + ", status=" + status + "]";
    }
}
