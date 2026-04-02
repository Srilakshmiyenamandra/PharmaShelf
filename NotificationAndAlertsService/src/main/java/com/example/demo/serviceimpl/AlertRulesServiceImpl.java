package com.example.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AlertRulesDTO;
import com.example.demo.entity.AlertRules;
import com.example.demo.exceptions.AlertRuleException;
import com.example.demo.exceptions.AlertRuleNotFoundException;
import com.example.demo.exceptions.InvalidAlertRuleException;
import com.example.demo.repository.AlertRulesRepository;
import com.example.demo.service.AlertRulesService;

@Service
public class AlertRulesServiceImpl implements AlertRulesService {

    @Autowired
    private AlertRulesRepository alertRulesRepo;

    @Override
    public AlertRulesDTO saveAlertRule(AlertRulesDTO dto) {
        if (dto == null) {
            throw new InvalidAlertRuleException("Alert rule payload must not be null.");
        }
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new InvalidAlertRuleException("Alert rule name is required.");
        }
        if (dto.getTriggerExpressionNote() == null || dto.getTriggerExpressionNote().trim().isEmpty()) {
            throw new InvalidAlertRuleException("Trigger expression note is required.");
        }

        AlertRules rule = new AlertRules();
        rule.setRuleID(dto.getRuleID());
        rule.setName(dto.getName());
        rule.setTriggerExpressionNote(dto.getTriggerExpressionNote());
        rule.setSeverity(dto.getSeverity());
        rule.setRecipientsList(dto.getRecipientsList());
        rule.setActive(dto.getActive());

        try {
            AlertRules savedRule = alertRulesRepo.save(rule);
            dto.setRuleID(savedRule.getRuleID());
            return dto;
        } catch (Exception ex) {
            throw new AlertRuleException("Failed to save alert rule: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<AlertRulesDTO> getAllAlertRules() {
        try {
            return alertRulesRepo.findAll().stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            throw new AlertRuleException("Failed to load alert rules: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<AlertRulesDTO> getActiveRules() {
        try {
            return alertRulesRepo.findByActiveTrue().stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            throw new AlertRuleException("Failed to load active alert rules: " + ex.getMessage(), ex);
        }
    }

    // Helper method for consistent conversion
    private AlertRulesDTO convertToDto(AlertRules rule) {
        AlertRulesDTO dto = new AlertRulesDTO();
        dto.setRuleID(rule.getRuleID());
        dto.setName(rule.getName());
        dto.setTriggerExpressionNote(rule.getTriggerExpressionNote());
        dto.setSeverity(rule.getSeverity());
        dto.setRecipientsList(rule.getRecipientsList());
        dto.setActive(rule.getActive());
        return dto;
    }
}