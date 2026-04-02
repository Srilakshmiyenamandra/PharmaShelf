package com.microservices.demo.exception;

/**
 * Exception thrown when attempting to create a resource that already exists.
 * Examples: Duplicate SKU, Duplicate Lot Number, Duplicate User Email, etc.
 */
public class DuplicateResourceException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public DuplicateResourceException(String resourceName, String field, String value) {
        super("DUP_RESOURCE", resourceName + " already exists with " + field + ": " + value);
    }

    public DuplicateResourceException(String message) {
        super("DUP_RESOURCE", message);
    }
}
