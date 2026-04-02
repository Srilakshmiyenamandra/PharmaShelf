package com.microservices.demo.exception;

/**
 * Exception thrown for Consumption Log related issues.
 * Examples: Invalid consumption period, product not found, invalid quantity, etc.
 */
public class ConsumptionLogException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public ConsumptionLogException(String logId, String reason) {
        super("CONSUMPTION_ERR", "Consumption log operation failed: " + reason);
    }

    public ConsumptionLogException(String message) {
        super("CONSUMPTION_ERR", message);
    }
}
