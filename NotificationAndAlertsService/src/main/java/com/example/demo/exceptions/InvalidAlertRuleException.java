package com.example.demo.exceptions;

public class InvalidAlertRuleException extends AlertRuleException {

    public InvalidAlertRuleException(String message) {
        super(message);
    }

    public InvalidAlertRuleException(String message, Throwable cause) {
        super(message, cause);
    }
}
