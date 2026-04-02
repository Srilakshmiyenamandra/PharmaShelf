package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.NotificationsDTO;
import com.example.demo.dto.RequiredResponseDTO; // Add this

public interface NotificationsService {
    
    NotificationsDTO createNotification(NotificationsDTO notifications);
   
    RequiredResponseDTO getAllDataByUserId(Long userId);
    
    List<NotificationsDTO> getNotificationsByUserId(Long userID);
}