package com.example.demo.dto;

import java.time.LocalDateTime;

public class AuditLogDTO {
	
	 private Long auditID;
     private Long userID;
     private String action;
     private String resource;
     private Long resourceID;
     private LocalDateTime timestamp;
     private String details;
	 public Long getAuditID() {
		 return auditID;
	 }
	 public void setAuditID(Long auditID) {
		 this.auditID = auditID;
	 }
	 public Long getUserID() {
		 return userID;
	 }
	 public void setUserID(Long userID) {
		 this.userID = userID;
	 }
	 public String getAction() {
		 return action;
	 }
	 public void setAction(String action) {
		 this.action = action;
	 }
	 public String getResource() {
		 return resource;
	 }
	 public void setResource(String resource) {
		 this.resource = resource;
	 }
	 public Long getResourceID() {
		 return resourceID;
	 }
	 public void setResourceID(Long resourceID) {
		 this.resourceID = resourceID;
	 }
	 public LocalDateTime getTimestamp() {
		 return timestamp;
	 }
	 public void setTimestamp(LocalDateTime timestamp) {
		 this.timestamp = timestamp;
	 }
	 public String getDetails() {
		 return details;
	 }
	 public void setDetails(String details) {
		 this.details = details;
	 }
	 @Override
	 public String toString() {
		return "AuditLogDTO [auditID=" + auditID + ", userID=" + userID + ", action=" + action + ", resource="
				+ resource + ", resourceID=" + resourceID + ", timestamp=" + timestamp + ", details=" + details + "]";
	 }
     
     
}
