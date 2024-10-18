package com.example.office_management.controllers;

import com.example.office_management.dto.CompanyCostDTO;
import com.example.office_management.models.Company;
import com.example.office_management.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "http://localhost:8234")  // Đảm bảo CORS được cấu hình đúng
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/costs")
    public ResponseEntity<List<CompanyCostDTO>> getCompanyCosts() {
        List<CompanyCostDTO> companyCosts = companyService.calculateServiceCosts();
        return ResponseEntity.ok(companyCosts);
    }
}