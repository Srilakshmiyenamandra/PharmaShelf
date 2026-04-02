package com.microservices.demo.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.demo.entity.Recall;



@Repository
public interface RecallRepository extends JpaRepository<Recall, Long> {

    // ==========================
    // PRODUCT BASED
    // ==========================

    List<Recall> findByProductId(Long productId);

    List<Recall> findByProductIdAndStatus(Long productId, String status);

    boolean existsByProductIdAndStatus(Long productId, String status);

    // ==========================
    // BATCH BASED
    // ==========================

    List<Recall> findByBatchId(Long batchId);

    List<Recall> findByBatchIdAndStatus(Long batchId, String status);

    boolean existsByBatchIdAndStatus(Long batchId, String status);

    // ==========================
    // STATUS / DATE
    // ==========================

    List<Recall> findByStatus(String status);

    List<Recall> findByRecalledAtBetween(
            LocalDate startDate,
            LocalDate endDate
    );
}