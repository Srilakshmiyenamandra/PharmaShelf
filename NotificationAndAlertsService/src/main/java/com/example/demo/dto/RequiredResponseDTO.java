package com.example.demo.dto;

import java.util.List;

public class RequiredResponseDTO {
    
    private UsersDTO user;
    private List<NotificationsDTO> notifications;

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
        this.user = user;
    }

    public List<NotificationsDTO> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationsDTO> notifications) {
        this.notifications = notifications;
    }

}