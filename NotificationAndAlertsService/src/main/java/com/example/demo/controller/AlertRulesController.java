package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AlertRulesDTO;
import com.example.demo.service.AlertRulesService;

@RestController
@RequestMapping("/api/alert-rules")
public class AlertRulesController {

    @Autowired
    private AlertRulesService alertRuleService;

    // 1. Create or Save an Alert Rule
    @PostMapping    
    public ResponseEntity<AlertRulesDTO> create(@RequestBody AlertRulesDTO alertRuleDto) {
        AlertRulesDTO savedRule = alertRuleService.saveAlertRule(alertRuleDto);
        return new ResponseEntity<>(savedRule, HttpStatus.CREATED);
    }

    // 2. Get All Alert Rules
    @GetMapping
    public ResponseEntity<List<AlertRulesDTO>> getAll() {
        List<AlertRulesDTO> rules = alertRuleService.getAllAlertRules();
        return new ResponseEntity<>(rules, HttpStatus.OK);
    }

    // 3. Get Only Active Rules
    @GetMapping("/active")
    public ResponseEntity<List<AlertRulesDTO>> getActive() {
        List<AlertRulesDTO> activeRules = alertRuleService.getActiveRules();
        return new ResponseEntity<>(activeRules, HttpStatus.OK);
    }
}