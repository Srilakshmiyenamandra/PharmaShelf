package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AuditLog")
public class AuditLog {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) 
        private Long auditID;
        
        private Long userID;
        
        private String action;
        
        //(e.g., "User", "Notification")
        private String resource;
        
        private Long resourceID;
        
        @CreationTimestamp
        private LocalDateTime timestamp;
        
        // (e.g., description, metadata)
        private String details;


        public AuditLog() {
            super();
        }

        public AuditLog(Long auditID, Long userID, String action, String resource, Long resourceID,
                LocalDateTime timestamp, String details) {
            super();
            this.auditID = auditID;
            this.userID = userID;
            this.action = action;
            this.resource = resource;
            this.resourceID = resourceID;
            this.timestamp = timestamp;
            this.details = details;
        }

       
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

}
