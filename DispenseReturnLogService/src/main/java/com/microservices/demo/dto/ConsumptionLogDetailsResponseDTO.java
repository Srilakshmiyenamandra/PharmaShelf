package com.microservices.demo.dto;



public class ConsumptionLogDetailsResponseDTO {

    private ConsumptionLogDTO consumptionLog;
    private ProductDTO product;

    public ConsumptionLogDetailsResponseDTO() {}

    public ConsumptionLogDetailsResponseDTO(
            ConsumptionLogDTO consumptionLog,
            ProductDTO product) {
        this.consumptionLog = consumptionLog;
        this.product = product;
    }

    public ConsumptionLogDTO getConsumptionLog() {
        return consumptionLog;
    }

    public void setConsumptionLog(ConsumptionLogDTO consumptionLog) {
        this.consumptionLog = consumptionLog;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}