package com.microservices.report.dto;

public class KpiDTO {
    private Long kpiId;
    private String name;
    private String definition;
    private Double target;
    private Double currentValue;
    private String reportingPeriod;

    // Getters and Setters
    public Long getKpiId() { return kpiId; }
    public void setKpiId(Long kpiId) { this.kpiId = kpiId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDefinition() { return definition; }
    public void setDefinition(String definition) { this.definition = definition; }

    public Double getTarget() { return target; }
    public void setTarget(Double target) { this.target = target; }

    public Double getCurrentValue() { return currentValue; }
    public void setCurrentValue(Double currentValue) { this.currentValue = currentValue; }

    public String getReportingPeriod() { return reportingPeriod; }
    public void setReportingPeriod(String reportingPeriod) { this.reportingPeriod = reportingPeriod; }
}
