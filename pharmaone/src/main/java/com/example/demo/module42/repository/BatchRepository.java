package com.example.demo.module42.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.module42.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {

    // ✅ Correct method for fetching batches by productId
    List<Batch> findByProduct_ProductId(Long productId);
}
