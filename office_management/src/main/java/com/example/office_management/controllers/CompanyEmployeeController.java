package com.example.office_management.controllers;

import com.example.office_management.models.CompanyEmployee;
import com.example.office_management.services.CompanyEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-employees")
@CrossOrigin(origins = "http://localhost:8234")
public class CompanyEmployeeController {
    @Autowired
    private CompanyEmployeeService companyEmployeeService;

    @GetMapping
    public List<CompanyEmployee> getAllCompanyEmployees() {
        return companyEmployeeService.getAllCompanyEmployees();
    }


}