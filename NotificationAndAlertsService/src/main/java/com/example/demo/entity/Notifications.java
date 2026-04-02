package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Notifications {
    
    
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long notificationID;
    
    
    private Long userID;
    
    private Long entityID;
    
    private String message;
    
    //(e.g., "EXPIRY", "STOCK", "PO", "RECALL")
    private String category;
    
    //(e.g., "READ", "UNREAD")
    private String status;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    

    public Notifications() {
        super();
    }

    public Notifications(Long notificationID, Long userID, Long entityID, String message, String category, String status,
            LocalDateTime createdAt) {
        super();
        this.notificationID = notificationID;
        this.userID = userID;
        this.entityID = entityID;
        this.message = message;
        this.category = category;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getNotificationID() {
        return notificationID;
    }
    
    public void setNotificationID(Long notificationID) {
        this.notificationID = notificationID;
    }


    public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getEntityID() {
        return entityID;
    }
    
    public void setEntityID(Long entityID) {
        this.entityID = entityID;
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
