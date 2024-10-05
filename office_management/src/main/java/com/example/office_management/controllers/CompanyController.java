package com.example.office_management.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.office_management.models.Company;
import com.example.office_management.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "http://localhost:8234")
public class CompanyController {
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        System.out.println("Returning " + companies.size() + " companies");
        return companies;
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @PutMapping("/{CompanyId}")
    public Company updateCompany(@PathVariable Long CompanyId, @RequestBody Company company) {
        company.setId(CompanyId);
        return companyService.saveCompany(company);
    }

    @DeleteMapping("/{CompanyId}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }
}