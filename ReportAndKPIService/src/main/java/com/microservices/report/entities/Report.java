package com.microservices.report.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Enumerated(EnumType.STRING)
    private ReportScope scope;   

    @Column(columnDefinition = "TEXT")//telling DB to use TEXT datatype
    private String parametersJSON;
    private String generatedBy;
    private LocalDateTime generatedAt;
    private String reportURI;

   
    public Report() {} //empty constructor
    
    

    public Report(Long reportId, ReportScope scope, String parametersJSON, String generatedBy,
			LocalDateTime generatedAt, String reportURI) {
		super();
		this.reportId = reportId;
		this.scope = scope;
		this.parametersJSON = parametersJSON;
		this.generatedBy = generatedBy;
		this.generatedAt = generatedAt;
		this.reportURI = reportURI;
	}



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
