package com.microservices.demo.exception;

/**
 * Exception thrown for database operation failures.
 * Examples: Connection failures, transaction rollbacks, query execution errors.
 */
public class DatabaseException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public DatabaseException(String operation, String message) {
        super("DB_ERROR", "Database operation '" + operation + "' failed: " + message);
    }

    public DatabaseException(String message, Throwable cause) {
        super("DB_ERROR", message, cause);
    }

    public DatabaseException(String message) {
        super("DB_ERROR", message);
    }
}
