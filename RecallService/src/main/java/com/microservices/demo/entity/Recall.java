package com.microservices.demo.entity;




import jakarta.persistence.*;

import java.time.LocalDate;
/*	
A Recall is used to identify, stop, isolate, and track medicines that are unsafe to use,
 even if they are not yet expired.
Recall prevents dispensing of a medicine that has 
been declared unsafe by the manufacturer or regulator.
 */

@Entity
@Table(name="recall")
public class Recall {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recallId;


    private Long productId;

   
    private Long batchId;

    private String reason;

    private LocalDate recalledAt;

    private String recalledBy;

    private Double quantity;

    private String status;

    public Recall() {}

    public Recall(Long recallId,
                  Long productId,
                  Long batchId,
                  String reason,
                  LocalDate recalledAt,
                  String recalledBy,
                  Double quantity,
                  String status)
    {
        this.recallId = recallId;
        this.productId = productId;
        this.batchId = batchId;
        this.reason = reason;
        this.recalledAt = recalledAt;
        this.recalledBy = recalledBy;
        this.quantity = quantity;
        this.status = status;
    }

  

    public Long getRecallId()
    { 
    	return recallId; 
    	}
    public void setRecallId(Long recallId)
    { 
    	this.recallId = recallId; 
    	}

    public Long getProductId()
    { 
    	return productId; 
    	}
    public void setProductId(Long productId)
    { 
    	this.productId = productId; 
    	}

    public Long getBatchId()
    { 
    	return batchId;
    	}
    public void setBatchId(Long batchId)
    {
    	this.batchId = batchId; 
    	}

    public String getReason()
    {
    	return reason; 
    	}
    public void setReason(String reason)
    {
    	this.reason = reason; 
    	}

    public LocalDate getRecalledAt()
    { 
    	return recalledAt; 
    	}
    public void setRecalledAt(LocalDate recalledAt) 
    { 
    	this.recalledAt = recalledAt;
    	}

    public String getRecalledBy() 
    { 
    	return recalledBy;
    	}
    public void setRecalledBy(String recalledBy)
    { 
    	this.recalledBy = recalledBy; 
    	}

    public double getQuantity()
    { 
    	return quantity; 
    	}
    public void setQuantity(Double quantity)
    { 
    	this.quantity = quantity;
    	}

    public String getStatus() 
    { 
    	return status; 
    	}
    public void setStatus(String status) 
    { 
    	this.status = status;
    	}


}

