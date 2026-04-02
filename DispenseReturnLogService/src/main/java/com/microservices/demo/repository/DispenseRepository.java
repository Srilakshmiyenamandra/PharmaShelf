package com.microservices.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.demo.entity.Dispense;

@Repository
public interface DispenseRepository extends JpaRepository<Dispense, Long> {

    // BASIC FILTERS
    List<Dispense> findByPatientId(String patientId);
    List<Dispense> findByWardId(String wardId);
    List<Dispense> findByStatus(String status);

    // PRODUCT & BATCH (ID-only ✅)
    List<Dispense> findByProduct(Long product);
    List<Dispense> findByBatch(Long batch);

    // DATE / TIME
    List<Dispense> findByDispensedAtBetween(
            LocalDateTime startDate,
            LocalDateTime endDate
    );

    List<Dispense> findByDispensedAtAfter(LocalDateTime date);

    // USER / STAFF
    List<Dispense> findByDispensedBy(String dispensedBy);

    // COMBINATIONS
    List<Dispense> findByWardIdAndStatus(String wardId, String status);
    List<Dispense> findByPatientIdAndStatus(String patientId, String status);
    List<Dispense> findByProductAndStatus(Long product, String status);

    // EXISTS
    boolean existsByBatch(Long batch);
    boolean existsByProduct(Long product);
}