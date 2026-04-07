package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quarantines")
public class Quarantine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quarantineId;

    @Column(nullable = false)
    private Long batchId;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private Long quarantinedBy;

    @Column(nullable = false)
    private LocalDateTime quarantinedAt;

    private Long releasedBy;
    private LocalDateTime releasedAt;

    @Column(nullable = false)
    private String status;

    public Quarantine() {}

    public Quarantine(Long batchId, String reason, Long quarantinedBy, LocalDateTime quarantinedAt, String status) {
        this.batchId = batchId;
        this.reason = reason;
        this.quarantinedBy = quarantinedBy;
        this.quarantinedAt = quarantinedAt;
        this.status = status;
    }

    // Getters and Setters

    public Long getQuarantineId() {
        return quarantineId;
    }

    public void setQuarantineId(Long quarantineId) {
        this.quarantineId = quarantineId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getQuarantinedBy() {
        return quarantinedBy;
    }

    public void setQuarantinedBy(Long quarantinedBy) {
        this.quarantinedBy = quarantinedBy;
    }

    public LocalDateTime getQuarantinedAt() {
        return quarantinedAt;
    }

    public void setQuarantinedAt(LocalDateTime quarantinedAt) {
        this.quarantinedAt = quarantinedAt;
    }

    public Long getReleasedBy() {
        return releasedBy;
    }

    public void setReleasedBy(Long releasedBy) {
        this.releasedBy = releasedBy;
    }

    public LocalDateTime getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(LocalDateTime releasedAt) {
        this.releasedAt = releasedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
