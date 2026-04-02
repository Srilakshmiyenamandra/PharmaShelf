package com.example.demo.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String error, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", status.value());
        body.put("error", error);
        body.put("message", message);
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(InvalidNotificationException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleInvalidNotification(InvalidNotificationException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Invalid Notification", ex.getMessage());
    }

    @ExceptionHandler(NotificationNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleNotificationNotFound(NotificationNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Notification Not Found", ex.getMessage());
    }

    @ExceptionHandler(NotificationServiceException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleNotificationServiceException(NotificationServiceException ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Notification Service Error", ex.getMessage());
    }

    @ExceptionHandler(InvalidAlertRuleException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleInvalidAlertRule(InvalidAlertRuleException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Invalid Alert Rule", ex.getMessage());
    }

    @ExceptionHandler(AlertRuleNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleAlertRuleNotFound(AlertRuleNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Alert Rule Not Found", ex.getMessage());
    }

    @ExceptionHandler(AlertRuleException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleAlertRuleException(AlertRuleException ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Alert Rule Service Error", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error", ex.getMessage());
    }
}
