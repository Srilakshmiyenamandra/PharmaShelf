package com.example.demo.repository;

import com.example.demo.dto.RequiredResponseDTO;
import com.example.demo.entities.ExpiryAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpiryAlertRepository extends JpaRepository<ExpiryAlert, Long> {


}
