package com.example.office_management.services;

import com.example.office_management.models.Company;
import com.example.office_management.models.AccessHistory;
import com.example.office_management.models.CompanyEmployee;
import com.example.office_management.dto.EmployeeAccessDTO;
import com.example.office_management.repositories.AccessHistoryRepository;
import com.example.office_management.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccessHistoryService {
    @Autowired
    private AccessHistoryRepository accessHistoryRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<AccessHistory> getAllAccessHistory() {
        return accessHistoryRepository.findAll();
    }

    public List<EmployeeAccessDTO> getBuildingAccessList(LocalDateTime start, LocalDateTime end) {
        List<CompanyEmployee> employees = accessHistoryRepository.findAllEmployeesWithAccessHistory();

        return employees.stream().map(employee -> {
            List<AccessHistory> accessHistories = accessHistoryRepository
                    .findByCardEmployeeAndAccessTimeBetweenOrderByAccessTimeDesc(employee, start, end);
            Company company = companyRepository.findById(employee.getCompany().getCompanyId())
                    .orElseThrow(() -> new RuntimeException("Company not found for ID: " + employee.getCompany().getCompanyId()));
            System.out.println(company);
            System.out.println(accessHistories);
            return new EmployeeAccessDTO(
                    employee.getEmployeeId(),
                    employee.getFullName(),
                    company.getCompanyName(),
                    accessHistories.stream().map(ah -> new EmployeeAccessDTO.AccessDetailDTO(
                            ah.getAccessTime(),
                            ah.getAccessType().toString(),
                            ah.getAccessPoint()
                    )).collect(Collectors.toList())
            );
        }).collect(Collectors.toList());
    }
}