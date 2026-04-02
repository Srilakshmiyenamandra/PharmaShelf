package com.microservices.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.demo.entity.Batch;
 

 
 
@Repository
public interface BatchRepository extends JpaRepository <Batch, Long> {
	List<Batch> findByProductId(Long productId);
}
