package com.microservices.demo.exception;



public class RecallActiveException extends RuntimeException {

    public RecallActiveException(String type, Long id) {
        super(type + " with ID " + id + " is under ACTIVE recall");
    }
}