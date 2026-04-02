package com.example.demo.exceptions;

public class InvalidNotificationException extends NotificationException {

    public InvalidNotificationException(String message) {
        super(message);
    }

    public InvalidNotificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
