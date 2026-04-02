package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AlertRulesDTO;


public interface AlertRulesService {
    
    AlertRulesDTO saveAlertRule(AlertRulesDTO alertRule);
    
    List<AlertRulesDTO> getAllAlertRules();
    
    List<AlertRulesDTO> getActiveRules();

}
