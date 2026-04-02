package com.microservices.demo.exception;

/**
 * Exception thrown when a user lacks required permissions for an operation.
 * Examples: Pharmacist trying to create purchase order (Procurement Officer role),
 * Non-Auditor accessing audit logs, etc.
 */
public class UnauthorizedException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public UnauthorizedException(String userRole, String operation) {
        super("UNAUTHORIZED", "User role '" + userRole + "' is not authorized to perform: " + operation);
    }

    public UnauthorizedException(String message) {
        super("UNAUTHORIZED", message);
    }
}
