package com.example.demo.dto;

import java.time.LocalDateTime;

public class NotificationsDTO {
	
	private Long notificationID;
    private Long userID;
    private Long entityID;
    private String message;
    private String category;
    private String status;
    private LocalDateTime createdAt;
    
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
	@Override
	public String toString() {
		return "NotificationDTO [notificationID=" + notificationID + ", userID=" + userID + ", entityID=" + entityID
				+ ", message=" + message + ", category=" + category + ", status=" + status + ", createdAt=" + createdAt
				+ "]";
	}
    
    

}
