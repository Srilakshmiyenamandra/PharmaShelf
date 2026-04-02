package com.microservices.demo.exception;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " with ID " + id + " not found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
