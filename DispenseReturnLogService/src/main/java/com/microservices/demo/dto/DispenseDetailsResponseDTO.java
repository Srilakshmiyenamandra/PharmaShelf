package com.microservices.demo.dto;



public class DispenseDetailsResponseDTO {

    private DispenseDTO dispense;
    private ProductDTO product;
    private BatchDTO batch;

    public DispenseDetailsResponseDTO() {}

    public DispenseDetailsResponseDTO(
            DispenseDTO dispense,
            ProductDTO product,
            BatchDTO batch) {
        this.dispense = dispense;
        this.product = product;
        this.batch = batch;
    }

    public DispenseDTO getDispense() {
        return dispense;
    }

    public void setDispense(DispenseDTO dispense) {
        this.dispense = dispense;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public BatchDTO getBatch() {
        return batch;
    }

    public void setBatch(BatchDTO batch) {
        this.batch = batch;
    }
}