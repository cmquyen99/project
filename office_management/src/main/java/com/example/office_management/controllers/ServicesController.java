package com.example.office_management.controllers;

import com.example.office_management.models.Services;
import com.example.office_management.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:8234")
class ServicesController {
    @Autowired
    private ServicesService serviceService;

    @GetMapping
    public List<Services> getAllServices() {
        return serviceService.getAllServices();
    }


}