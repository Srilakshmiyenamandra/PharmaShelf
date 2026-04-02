package com.microservices.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.demo.entity.Returns;




@Repository
public interface ReturnRepository extends JpaRepository<Returns,Long> {
    List<Returns> findByBatch(Long batchId);
    List<Returns> findByDispense_DispenseId(Long dispenseId);
    List<Returns> findByStatus(Returns.Status status);
    List<Returns> findByReturnedAtBetween(LocalDate start, LocalDate end);
}
