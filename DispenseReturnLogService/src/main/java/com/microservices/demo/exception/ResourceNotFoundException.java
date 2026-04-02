package com.microservices.demo.exception;

/**
 * Exception thrown when a requested resource (Product, Batch, Order, etc.) is not found.
 * Used across all entities: Product, Batch, Dispense, Return, PurchaseOrder, GoodsReceipt, etc.
 */
public class ResourceNotFoundException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String resourceName, Long id) {
        super("RES_NOT_FOUND", resourceName + " not found with ID: " + id);
    }

    public ResourceNotFoundException(String resourceName, String identifier) {
        super("RES_NOT_FOUND", resourceName + " not found with identifier: " + identifier);
    }

    public ResourceNotFoundException(String message) {
        super("RES_NOT_FOUND", message);
    }
}
