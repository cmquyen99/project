package com.example.office_management.services;

import com.example.office_management.dto.CompanyCostDTO;
import com.example.office_management.models.Company;
import com.example.office_management.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.math.*;
import java.time.*;

@Service
public class CompanyService {

    private final JdbcTemplate jdbcTemplate;
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(JdbcTemplate jdbcTemplate, CompanyRepository companyRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public List<CompanyCostDTO> calculateServiceCosts() {
        List<Company> companies = getAllCompanies();
        List<CompanyCostDTO> companyCosts = new ArrayList<>();

        for (Company company : companies) {
            BigDecimal cleaningCost = calculateServiceCost(company, new BigDecimal("1000000"));
            BigDecimal cateringCost = calculateServiceCost(company, new BigDecimal("2000000"));
            BigDecimal parkingCost = calculateServiceCost(company, new BigDecimal("500000"));
            BigDecimal securityCost = calculateServiceCost(company, new BigDecimal("1500000"));
            BigDecimal maintenanceCost = calculateServiceCost(company, new BigDecimal("2500000"));

            BigDecimal totalCost = cleaningCost
                    .add(cateringCost)
                    .add(parkingCost)
                    .add(securityCost)
                    .add(maintenanceCost);

            CompanyCostDTO costDTO = new CompanyCostDTO(
                    company.getCompanyId(),
                    company.getCompanyName(),
                    cleaningCost,
                    cateringCost,
                    parkingCost,
                    securityCost,
                    maintenanceCost,
                    totalCost
            );

            companyCosts.add(costDTO);
        }

        return companyCosts;
    }

    private BigDecimal calculateServiceCost(Company company, BigDecimal basePrice) {
        int employeeCount = company.getEmployeeCount();
        BigDecimal floorArea = company.getFloorArea();

        int employeeIncrement = Math.max(0, (employeeCount - 10) / 5);
        int areaIncrement = Math.max(0, floorArea.subtract(new BigDecimal("100")).divide(new BigDecimal("10"), 0, RoundingMode.FLOOR).intValue());

        int totalIncrements = employeeIncrement + areaIncrement;
        BigDecimal incrementFactor = BigDecimal.ONE.add(new BigDecimal("0.05").multiply(new BigDecimal(totalIncrements)));

        return basePrice.multiply(incrementFactor).setScale(0, RoundingMode.HALF_UP);
    }
}
