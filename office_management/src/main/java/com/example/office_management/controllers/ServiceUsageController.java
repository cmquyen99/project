package com.example.office_management.controllers;

import com.example.office_management.models.ServiceUsage;
import com.example.office_management.services.ServiceUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-usages")
@CrossOrigin(origins = "http://localhost:8234")
public class ServiceUsageController {
    @Autowired
    private ServiceUsageService serviceUsageService;

    @GetMapping
    public List<ServiceUsage> getAllServiceUsages() {
        return serviceUsageService.getAllServiceUsages();
    }

}