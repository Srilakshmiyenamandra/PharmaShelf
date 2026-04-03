package com.microservices.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.microservices.report.entities.Report;

@Repository
public interface ReportRepo extends JpaRepository<Report, Long> {
    // You can add custom queries if needed, e.g.:
    // List<Report> findByScope(ReportScope scope);
}
