package com.microservices.demo.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

//Track medicine consumption

@Entity
@Table(name="consumptionLog")
public class ConsumptionLog {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;


    private Long product;

    private LocalDateTime periodStart;

    private LocalDateTime periodEnd;

    private Double quantityUsed;

    private LocalDateTime generatedAt;



    public ConsumptionLog() {}

    public ConsumptionLog(Long logId,
                          Long product,
                          LocalDateTime periodStart,
                          LocalDateTime periodEnd,
                          Double quantityUsed,
                          LocalDateTime generatedAt) 
    {
        this.logId = logId;
        this.product = product;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.quantityUsed = quantityUsed;
        this.generatedAt = generatedAt;
       
    }



    public Long getLogId() 
    { 
    	return logId; 
    	}
    public void setLogId(Long logId)
    { 
    	this.logId = logId; 
    	}

    public Long getProduct()
    {
    	return product;
    	}
    public void setProduct(Long product)
    { 
    	this.product = product;
    	}

    public LocalDateTime getPeriodStart()
    { 
    	return periodStart; 
    	}
    public void setPeriodStart(LocalDateTime periodStart)
    {
    	this.periodStart = periodStart; 
    	}

    public LocalDateTime getPeriodEnd()
    { 
    	return periodEnd;
    	}
    public void setPeriodEnd(LocalDateTime periodEnd)
    {
    	this.periodEnd = periodEnd; 
    	}

    public Double getQuantityUsed()
    { 
    	return quantityUsed; 
    	}
    public void setQuantityUsed(double quantityUsed)
    { 
    	this.quantityUsed = quantityUsed; 
    	}

    public LocalDateTime getGeneratedAt()
    {
    	return generatedAt; 
    	}
    public void setGeneratedAt(LocalDateTime generatedAt)
    { 
    	this.generatedAt = generatedAt;
    	}


    @Override
    public String toString() {
        return "ConsumptionLog{" +
                "logId='" + logId + '\'' +
                ", product=" + 
                ", periodStart=" + periodStart +
                ", periodEnd=" + periodEnd +
                ", quantityUsed=" + quantityUsed +
                ", generatedAt=" + generatedAt +
                
                '}';
    }
}