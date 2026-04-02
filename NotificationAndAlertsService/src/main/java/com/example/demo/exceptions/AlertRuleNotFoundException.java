package com.example.demo.exceptions;

public class AlertRuleNotFoundException extends AlertRuleException {

    public AlertRuleNotFoundException(String message) {
        super(message);
    }

    public AlertRuleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
