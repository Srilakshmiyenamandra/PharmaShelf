package com.example.demo.repository;

import com.example.demo.entities.Quarantine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuarantineRepository extends JpaRepository<Quarantine, Long> {
}
