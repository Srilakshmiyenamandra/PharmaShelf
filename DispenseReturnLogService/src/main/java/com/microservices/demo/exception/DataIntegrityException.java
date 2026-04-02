package com.microservices.demo.exception;

/**
 * Exception thrown when database integrity constraints are violated.
 * Examples: Foreign key violations, referential integrity errors,
 * attempting to delete a product with active batches, etc.
 */
public class DataIntegrityException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public DataIntegrityException(String entity, String constraint, String message) {
        super("DATA_INTEGRITY", "Data integrity violation for " + entity + 
              " (" + constraint + "): " + message);
    }

    public DataIntegrityException(String message) {
        super("DATA_INTEGRITY", message);
    }
}
