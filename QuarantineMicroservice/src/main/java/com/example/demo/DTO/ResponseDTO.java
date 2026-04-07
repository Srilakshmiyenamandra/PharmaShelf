package com.example.demo.DTO;


public class ResponseDTO {
    private QuarantineDTO quarantine;
    private BatchDTO batch;

    public ResponseDTO() {}

    public ResponseDTO(QuarantineDTO quarantine, BatchDTO batch) {
        this.quarantine = quarantine;
        this.batch = batch;
    }

    public QuarantineDTO getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(QuarantineDTO quarantine) {
        this.quarantine = quarantine;
    }

    public BatchDTO getBatch() {
        return batch;
    }

    public void setBatch(BatchDTO batch) {
        this.batch = batch;
    }
}
