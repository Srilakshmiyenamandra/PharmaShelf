package com.example.demo.module42.dto;

public class ProductDTO {
    private Long productId;
    private String sku;
    private String name;
    private String genericName;
    private String formulation;
    private String strength;
    private String uom;
    private String storageCondition;
    private String status;

    public ProductDTO() {}

    public ProductDTO(Long productId, String sku, String name, String genericName, String formulation,
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
        return "ProductDTO [productId=" + productId + ", sku=" + sku + ", name=" + name + ", genericName="
                + genericName + ", formulation=" + formulation + ", strength=" + strength + ", uom=" + uom
                + ", storageCondition=" + storageCondition + ", status=" + status + "]";
    }
}
