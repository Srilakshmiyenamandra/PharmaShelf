package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AlertRules;

@Repository
public interface AlertRulesRepository extends JpaRepository<AlertRules, Long> {

    List<AlertRules> findByActiveTrue();
}