package com.example.office_management.services;

import com.example.office_management.models.EmployeeSalary;
import com.example.office_management.repositories.EmployeeSalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeSalaryService {
    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

    public List<EmployeeSalary> getAllEmployeeSalaries() {
        return employeeSalaryRepository.findAll();
    }

    public EmployeeSalary saveEmployeeSalary(EmployeeSalary salary) {
        return employeeSalaryRepository.save(salary);
    }
}