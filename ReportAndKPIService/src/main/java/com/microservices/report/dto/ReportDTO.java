package com.microservices.report.dto;


import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.microservices.report.entities.ReportScope;


public class ReportDTO {

   
  
    private Long reportId;

    @Enumerated(EnumType.STRING)
    private ReportScope scope;   

    @Column(columnDefinition = "TEXT")//telling DB to use TEXT datatype
    private String parametersJSON;
    private String generatedBy;
    private LocalDateTime generatedAt;
    private String reportURI;

   

    
    



	// Getters and Setters
    
    public Long getReportId() 
    { return reportId; }
    
    
    public void setReportId(Long reportId) 
    { this.reportId = reportId; }

    public ReportScope getScope() 
    { return scope; }
    
    public void setScope(ReportScope scope) 
    { this.scope = scope; }

    public String getParametersJSON() 
    { return parametersJSON; }
    
    public void setParametersJSON(String parametersJSON) 
    { this.parametersJSON = parametersJSON; }

    public String getGeneratedBy() 
    { return generatedBy; }
    
    public void setGeneratedBy(String generatedBy)
    { this.generatedBy = generatedBy; }

    public LocalDateTime getGeneratedAt() 
    { return generatedAt; }
    
    public void setGeneratedAt(LocalDateTime generatedAt) 
    { this.generatedAt = generatedAt; }

    public String getReportURI() { return reportURI; }
    public void setReportURI(String reportURI) { this.reportURI = reportURI; }
}
