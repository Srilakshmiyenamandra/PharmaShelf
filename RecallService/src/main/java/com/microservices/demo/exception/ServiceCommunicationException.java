package com.microservices.demo.exception;


public class ServiceCommunicationException extends RuntimeException {

    public ServiceCommunicationException(String service, String message) {
        super("Failed to communicate with " + service + ": " + message);
    }
}