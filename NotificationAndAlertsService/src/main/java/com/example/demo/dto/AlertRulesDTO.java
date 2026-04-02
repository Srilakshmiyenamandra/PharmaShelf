package com.example.demo.dto;

public class AlertRulesDTO {
	
	private Long ruleID;
    private String name;
    private String triggerExpressionNote;
    private String severity;
    private String recipientsList;
    private Boolean active;
    
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
	@Override
	public String toString() {
		return "AlertRuleDTO [ruleID=" + ruleID + ", name=" + name + ", triggerExpressionNote=" + triggerExpressionNote
				+ ", severity=" + severity + ", recipientsList=" + recipientsList + ", active=" + active + "]";
	}
    

}
