package com.microservices.report.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "kpi")
public class KPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kpiId; //Long is a wrapper class

    private String name;
    private String definition;
    private Double target;
    private Double currentValue;
    private String reportingPeriod; 

    public KPI() {}

    public KPI(Long kpiId,
               String name,
               String definition,
               Double target,
               Double currentValue,
               String reportingPeriod) {
        this.kpiId = kpiId;
        this.name = name;
        this.definition = definition;
        this.target = target;
        this.currentValue = currentValue;
        this.reportingPeriod = reportingPeriod;
    }

    public Long getKpiId() {
        return kpiId;
    }

    public void setKpiId(Long kpiId) {
        this.kpiId = kpiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public String getReportingPeriod() {
        return reportingPeriod;
    }

    public void setReportingPeriod(String reportingPeriod) {
        this.reportingPeriod = reportingPeriod;
    }

    @Override
    public String toString() {
        return "KPI{" +
                "kpiId=" + kpiId +
                ", name='" + name + '\'' +
                ", definition='" + definition + '\'' +
                ", target=" + target +
                ", currentValue=" + currentValue +
                ", reportingPeriod='" + reportingPeriod + '\'' +
                '}';
    }
}