package com.example.office_management.services;

import com.example.office_management.models.CompanyEmployee;
import com.example.office_management.repositories.CompanyEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyEmployeeService {
    @Autowired
    private CompanyEmployeeRepository companyEmployeeRepository;

    public List<CompanyEmployee> getAllCompanyEmployees() {
        return companyEmployeeRepository.findAll();
    }

    public CompanyEmployee saveCompanyEmployee(CompanyEmployee employee) {
        return companyEmployeeRepository.save(employee);
    }
}