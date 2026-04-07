package com.example.demo.repository;

import com.example.demo.entities.StockCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockCountRepository extends JpaRepository<StockCount, Long> {
}