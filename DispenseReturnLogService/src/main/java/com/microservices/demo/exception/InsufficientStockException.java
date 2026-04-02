package com.microservices.demo.exception;

/**
 * Exception thrown when attempting to dispense or allocate quantity that exceeds available stock.
 * Used during dispensing, returns, and stock transfers.
 */
public class InsufficientStockException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;
    private Long requestedQuantity;
    private Long availableQuantity;

    public InsufficientStockException(String productName, Long requested, Long available) {
        super("INSUF_STOCK", "Insufficient stock for " + productName + 
              ". Requested: " + requested + ", Available: " + available);
        this.requestedQuantity = requested;
        this.availableQuantity = available;
    }

    public InsufficientStockException(String message) {
        super("INSUF_STOCK", message);
    }

    public Long getRequestedQuantity() {
        return requestedQuantity;
    }

    public Long getAvailableQuantity() {
        return availableQuantity;
    }
}
