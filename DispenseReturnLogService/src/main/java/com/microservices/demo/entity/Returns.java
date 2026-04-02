package com.microservices.demo.entity;

import jakarta.persistence.*;


import java.time.LocalDate;

//Handle returns
@Entity
@Table(name="returnTable")
public class Returns {

    public enum Status {
        ACTIVE,
        INACTIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long returnId;

 
    private Long batch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispense_id")
    private Dispense dispense;

    private String reason;

    private LocalDate returnedAt;

    private String returnedBy;

    private double quantity;

    @Enumerated(EnumType.STRING)

    private Status status;

    public Returns() {}

    public Returns(Long returnId,
                  Long batch,
                  Dispense dispense,
                  String reason,
                  LocalDate returnedAt,
                  String returnedBy,
                  double quantity,
                  Status status) 
    {
        this.returnId = returnId;
        this.batch = batch;
        this.dispense = dispense;
        this.reason = reason;
        this.returnedAt = returnedAt;
        this.returnedBy = returnedBy;
        this.quantity = quantity;
        this.status = status;
    }



    public Long getReturnId() 
    { 
    	return returnId; 
    	}
    public void setReturnId(Long returnId) 
    { 
    	this.returnId = returnId;
    	}

    public Long getBatch()
    { 
    	return batch;
    }
    public void setBatch(Long batch) 
    { 
    	this.batch = batch; 
    	}

    public Dispense getDispense()
    { 
    	return dispense; 
    	}
    public void setDispense(Dispense dispense) 
    { 
    	this.dispense = dispense; 
    	}

    public String getReason()
    { 
    	return reason; 
    	}
    public void setReason(String reason) 
    { 
    	this.reason = reason; 
    	}

    public LocalDate getReturnedAt() 
    { 
    	return returnedAt; 
    	}
    public void setReturnedAt(LocalDate returnedAt) 
    { 
    	this.returnedAt = returnedAt; 
    	}

    public String getReturnedBy() 
    {
    	return returnedBy; 
    	}
    public void setReturnedBy(String returnedBy) 
    { 
    	this.returnedBy = returnedBy; 
    	}

    public double getQuantity() 
    { 
    	return quantity; 
    }
    public void setQuantity(double quantity) 
    { 
    	this.quantity = quantity; 
    	}

    public Status getStatus() 
    { 
    	return status; 
    	}
    public void setStatus(Status status) 
    { 
    	this.status = status; 
    	}

    @Override
    public String toString() {
        return "Return{" +
                "returnId='" + returnId + '\'' +
                ", batch=" + 
                ", dispense=" + (dispense != null ? dispense.getDispenseId() : null) +
                ", reason='" + reason + '\'' +
                ", returnedAt=" + returnedAt +
                ", returnedBy='" + returnedBy + '\'' +
                ", quantity=" + quantity +
                ", status=" + status +
                '}';
    }
}