package com.example.demo.exceptions;

public class AlertRuleException extends RuntimeException {

    public AlertRuleException(String message) {
        super(message);
    }

    public AlertRuleException(String message, Throwable cause) {
        super(message, cause);
    }
}
