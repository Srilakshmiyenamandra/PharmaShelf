package com.microservices.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservices.demo.dto.ConsumptionLogDTO;
import com.microservices.demo.dto.ConsumptionLogDetailsResponseDTO;
import com.microservices.demo.dto.RequiredResponseDTO;
import com.microservices.demo.service.ConsumptionLogService;

@RestController
@RequestMapping("/api/consumption-logs")
public class ConsumptionLogController {

    @Autowired
    private ConsumptionLogService service;

    // ==========================
    // CREATE
    // ==========================

    @PostMapping
    public ResponseEntity<RequiredResponseDTO<ConsumptionLogDTO>> create(
            @RequestBody ConsumptionLogDTO dto) {

        ConsumptionLogDTO created = service.insertConsumptionLog(dto);
        return new ResponseEntity<>(
                new RequiredResponseDTO<>(true, "Consumption log created", created),
                HttpStatus.CREATED
        );
    }

    // ==========================
    // GET ALL
    // ==========================

    @GetMapping
    public ResponseEntity<RequiredResponseDTO<List<ConsumptionLogDTO>>> getAll() {

        List<ConsumptionLogDTO> all = service.getAll();
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Consumption logs fetched", all)
        );
    }

    // ==========================
    // GET BY ID
    // ==========================

    @GetMapping("/{id}")
    public ResponseEntity<RequiredResponseDTO<ConsumptionLogDTO>> getById(
            @PathVariable long id) {

        ConsumptionLogDTO log = service.getById(id);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Consumption log fetched", log)
        );
    }

    // ==========================
    // ✅ DETAILS (ConsumptionLog + Product)
    // ==========================

    @GetMapping("/{id}/details")
    public ResponseEntity<RequiredResponseDTO<ConsumptionLogDetailsResponseDTO>> getDetails(
            @PathVariable Long id) {

        ConsumptionLogDetailsResponseDTO details =
                service.getConsumptionLogDetails(id);

        return ResponseEntity.ok(
                new RequiredResponseDTO<>(
                        true,
                        "Consumption log details fetched",
                        details
                )
        );
    }

    // ==========================
    // FILTERS
    // ==========================

    @GetMapping("/product/{productId}")
    public ResponseEntity<RequiredResponseDTO<List<ConsumptionLogDTO>>> getByProduct(
            @PathVariable long productId) {

        List<ConsumptionLogDTO> data = service.getByProduct(productId);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Consumption logs by product fetched", data)
        );
    }

    @GetMapping("/period")
    public ResponseEntity<RequiredResponseDTO<List<ConsumptionLogDTO>>> getByPeriod(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime from,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime to) {

        List<ConsumptionLogDTO> data = service.getByPeriod(from, to);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Consumption logs by period fetched", data)
        );
    }

    // ==========================
    // UPDATE
    // ==========================

    @PutMapping("/{id}")
    public ResponseEntity<RequiredResponseDTO<ConsumptionLogDTO>> update(
            @PathVariable long id,
            @RequestBody ConsumptionLogDTO dto) {

        dto.setLogId(id);
        ConsumptionLogDTO updated = service.updateLog(dto);

        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Consumption log updated", updated)
        );
    }

    // ==========================
    // DELETE
    // ==========================

    @DeleteMapping("/{id}")
    public ResponseEntity<RequiredResponseDTO<Void>> delete(
            @PathVariable long id) {

        service.delById(id);
        return ResponseEntity.ok(
                new RequiredResponseDTO<>(true, "Consumption log deleted", null)
        );
    }
}