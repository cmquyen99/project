package com.example.office_management.controllers;

import com.example.office_management.models.AccessHistory;
import com.example.office_management.services.AccessHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public AccessHistory createAccessHistory(@RequestBody AccessHistory accessHistory) {
        return accessHistoryService.saveAccessHistory(accessHistory);
    }
}