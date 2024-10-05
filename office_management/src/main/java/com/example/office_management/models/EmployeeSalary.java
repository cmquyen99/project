package com.example.office_management.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employee_salary")
public class EmployeeSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryId;
    private BigDecimal baseSalary;
    private Integer salaryMonth;
    private BigDecimal serviceBonus;
    private BigDecimal totalSalary;
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private BuildingEmployee employee;

    // Getters and setters
    public Long getSalaryId() { return salaryId; }
    public void setSalaryId(Long salaryId) { this.salaryId = salaryId; }
    public BigDecimal getBaseSalary() { return baseSalary; }
    public void setBaseSalary(BigDecimal baseSalary) { this.baseSalary = baseSalary; }
    public Integer getSalaryMonth() { return salaryMonth; }
    public void setSalaryMonth(Integer salaryMonth) { this.salaryMonth = salaryMonth; }
    public BigDecimal getServiceBonus() { return serviceBonus; }
    public void setServiceBonus(BigDecimal serviceBonus) { this.serviceBonus = serviceBonus; }
    public BigDecimal getTotalSalary() { return totalSalary; }
    public void setTotalSalary(BigDecimal totalSalary) { this.totalSalary = totalSalary; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public BuildingEmployee getEmployee() { return employee; }
    public void setEmployee(BuildingEmployee employee) { this.employee = employee; }
}