package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.NotificationsDTO;
import com.example.demo.dto.RequiredResponseDTO;
import com.example.demo.service.NotificationsService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationService;


    @GetMapping("/user/{userId}")
    public ResponseEntity<RequiredResponseDTO> getMyAlerts(@PathVariable Long userId) {
        // This calls the service logic that uses RestTemplate to fetch User info
        RequiredResponseDTO response = notificationService.getAllDataByUserId(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    
    @PostMapping
    public ResponseEntity<NotificationsDTO> sendNotification(@RequestBody NotificationsDTO notificationDto) {
        NotificationsDTO createdNotification = notificationService.createNotification(notificationDto);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }
}