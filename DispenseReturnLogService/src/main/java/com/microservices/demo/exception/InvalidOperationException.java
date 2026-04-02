package com.microservices.demo.exception;

/**
 * Exception thrown when an operation cannot be performed due to invalid state or constraints.
 * Examples: Dispensing from expired batch, returning more than was dispensed,
 * releasing quarantine without approval, etc.
 */
public class InvalidOperationException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public InvalidOperationException(String operation, String reason) {
        super("INVALID_OP", "Operation '" + operation + "' failed: " + reason);
    }

    public InvalidOperationException(String message) {
        super("INVALID_OP", message);
    }
}
