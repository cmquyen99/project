package com.example.office_management.controllers;

import com.example.office_management.models.ServiceAssignment;
import com.example.office_management.services.ServiceAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-assignments")
@CrossOrigin(origins = "http://localhost:8234")
public class ServiceAssignmentController {
    @Autowired
    private ServiceAssignmentService serviceAssignmentService;

    @GetMapping
    public List<ServiceAssignment> getAllServiceAssignments() {
        return serviceAssignmentService.getAllServiceAssignments();
    }

}