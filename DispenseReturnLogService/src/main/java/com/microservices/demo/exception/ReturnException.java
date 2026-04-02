package com.microservices.demo.exception;

/**
 * Exception thrown for Return related issues.
 * Examples: Cannot return more than dispensed, invalid return reason,
 * cannot return from non-existent dispense record, etc.
 */
public class ReturnException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public ReturnException(String returnId, String reason) {
        super("RETURN_ERR", "Return operation failed: " + reason);
    }

    public ReturnException(String message) {
        super("RETURN_ERR", message);
    }
}
