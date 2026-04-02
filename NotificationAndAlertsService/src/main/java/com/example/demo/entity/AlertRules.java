package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AlertRules {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long ruleID;
    
    // (e.g., "Near Expiry")
    private String name;
    
    // (e.g., "DaysToExpiry <= 30")
    private String triggerExpressionNote;
    
    //(e.g., "LOW", "MEDIUM", "HIGH", "CRITICAL")
    private String severity;
   
    private String recipientsList;
    
    private Boolean active;
    
    public AlertRules() {
        super();
    }

    public AlertRules(Long ruleID, String name, String triggerExpressionNote, String severity, String recipientsList,
            Boolean active) {
        super();
        this.ruleID = ruleID;
        this.name = name;
        this.triggerExpressionNote = triggerExpressionNote;
        this.severity = severity;
        this.recipientsList = recipientsList;
        this.active = active;
    }


    public Long getRuleID() {
        return ruleID;
    }
    public void setRuleID(Long ruleID) {
        this.ruleID = ruleID;
    }

  
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getTriggerExpressionNote() {
        return triggerExpressionNote;
    }
    public void setTriggerExpressionNote(String triggerExpressionNote) {
        this.triggerExpressionNote = triggerExpressionNote;
    }

   
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    
    public String getRecipientsList() {
        return recipientsList;
    }
    public void setRecipientsList(String recipientsList) {
        this.recipientsList = recipientsList;
    }

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

    
    
    
}
