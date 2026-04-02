package com.microservices.demo.exception;

/**
 * Base exception class for all PharmaShelf application exceptions.
 * Provides a common hierarchy for error handling across all modules.
 */
public class PharmaShelfException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;

    public PharmaShelfException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public PharmaShelfException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public PharmaShelfException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
    }

    public PharmaShelfException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
