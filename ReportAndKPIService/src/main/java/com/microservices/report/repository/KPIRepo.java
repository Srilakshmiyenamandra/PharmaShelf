package com.microservices.report.repository;

import com.microservices.report.entities.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KPIRepo extends JpaRepository<KPI, Long> {
    // Custom queries can be added here if needed
}
