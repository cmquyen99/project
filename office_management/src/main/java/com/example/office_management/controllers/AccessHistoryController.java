package com.example.office_management.controllers;

import com.example.office_management.models.AccessHistory;
import com.example.office_management.services.AccessHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.example.office_management.dto.EmployeeAccessDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/access-history")
@CrossOrigin(origins = "http://localhost:8234")
public class AccessHistoryController {
    @Autowired
    private AccessHistoryService accessHistoryService;

    @GetMapping
    public List<AccessHistory> getAllAccessHistory() {
        return accessHistoryService.getAllAccessHistory();
    }

    @GetMapping("/building-access-list")
    public ResponseEntity<List<EmployeeAccessDTO>> getBuildingAccessList(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        if (start == null) {
            start = LocalDateTime.of(2023, 1, 1, 0, 0, 0);
            System.out.println(start);
        }
        if (end == null) {
            end = LocalDateTime.of(2025, 1, 1, 0, 0, 0);
        }
        List<EmployeeAccessDTO> accessList = accessHistoryService.getBuildingAccessList(start, end);
        return ResponseEntity.ok(accessList);
    }
}