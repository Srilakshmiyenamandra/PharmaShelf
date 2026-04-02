package com.microservices.demo.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Exception thrown for validation errors.
 * Supports multiple field validations for comprehensive error reporting.
 * Examples: Invalid quantity, invalid date range, missing required fields, etc.
 */
public class ValidationException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;
    private Map<String, String> fieldErrors;

    public ValidationException(String field, String message) {
        super("VALIDATION_ERR", "Validation failed for field '" + field + "': " + message);
        this.fieldErrors = new HashMap<>();
        this.fieldErrors.put(field, message);
    }

    public ValidationException(String message) {
        super("VALIDATION_ERR", message);
        this.fieldErrors = new HashMap<>();
    }

    public ValidationException(Map<String, String> fieldErrors) {
        super("VALIDATION_ERR", "Validation failed for " + fieldErrors.size() + " field(s)");
        this.fieldErrors = fieldErrors;
    }

    public void addFieldError(String field, String message) {
        if (this.fieldErrors == null) {
            this.fieldErrors = new HashMap<>();
        }
        this.fieldErrors.put(field, message);
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}
