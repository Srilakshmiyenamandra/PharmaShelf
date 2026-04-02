package com.microservices.demo.exception;

/**
 * Exception thrown for document/file storage operation failures.
 * Examples: Invoice upload failure, evidence attachment failure, file hash mismatch.
 */
public class DocumentStorageException extends PharmaShelfException {
    private static final long serialVersionUID = 1L;

    public DocumentStorageException(String documentType, String operation, String message) {
        super("DOC_STORAGE_ERR", "Document storage operation failed for " + documentType + 
              " (" + operation + "): " + message);
    }

    public DocumentStorageException(String message, Throwable cause) {
        super("DOC_STORAGE_ERR", message, cause);
    }

    public DocumentStorageException(String message) {
        super("DOC_STORAGE_ERR", message);
    }
}
