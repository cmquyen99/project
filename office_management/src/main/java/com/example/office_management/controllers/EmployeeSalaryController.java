package com.example.office_management.controllers;

import com.example.office_management.models.EmployeeSalary;
import com.example.office_management.services.EmployeeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-salaries")
@CrossOrigin(origins = "http://localhost:8234")
public class EmployeeSalaryController {
    @Autowired
    private EmployeeSalaryService employeeSalaryService;

    @GetMapping
    public List<EmployeeSalary> getAllEmployeeSalaries() {
        return employeeSalaryService.getAllEmployeeSalaries();
    }

    @PostMapping
    public EmployeeSalary createEmployeeSalary(@RequestBody EmployeeSalary salary) {
        return employeeSalaryService.saveEmployeeSalary(salary);
    }
}