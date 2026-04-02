package com.microservices.demo.dto;



public class ReturnDetailsResponseDTO {

    private ReturnDTO returnDetails;
    private BatchDTO batch;

    public ReturnDetailsResponseDTO() {}

    public ReturnDetailsResponseDTO(ReturnDTO returnDetails, BatchDTO batch) {
        this.returnDetails = returnDetails;
        this.batch = batch;
    }

    public ReturnDTO getReturnDetails() {
        return returnDetails;
    }

    public void setReturnDetails(ReturnDTO returnDetails) {
        this.returnDetails = returnDetails;
    }

    public BatchDTO getBatch() {
        return batch;
    }

    public void setBatch(BatchDTO batch) {
        this.batch = batch;
    }
}