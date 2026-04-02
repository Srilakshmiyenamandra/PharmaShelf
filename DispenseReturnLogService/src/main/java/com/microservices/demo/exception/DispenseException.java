package com.microservices.demo.exception;

/**
 * Exception thrown for Dispensing related issues.
 * Examples: Invalid batch selection, attempt to dispense expired/quarantined batch,
 * invalid patient/ward, missing authorization, etc.
 */
public class DispenseException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public DispenseException(String dispenseId, String reason) {
        super("DISPENSE_ERR", "Dispensing operation failed: " + reason);
    }

    public DispenseException(String message) {
        super("DISPENSE_ERR", message);
    }
}
