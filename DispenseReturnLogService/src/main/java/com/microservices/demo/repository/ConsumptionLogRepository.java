package com.microservices.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.demo.entity.ConsumptionLog;



@Repository
public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog,Long> {
    List<ConsumptionLog> findByProduct(Long productId);
    List<ConsumptionLog> findByGeneratedAtBetween(LocalDateTime start, LocalDateTime end);
}
