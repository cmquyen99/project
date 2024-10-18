package com.example.office_management.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId; // Đổi tên biến cho thống nhất về quy tắc đặt tên

    private String companyName;
    private String businessField;
    private BigDecimal charterCapital;
    private Integer employeeCount;
    private BigDecimal floorArea;
    private String officeAddress;
    private String phoneNumber;
    private String taxCode;

    // Constructors
    public Company() {}

    public Company(String companyName, String businessField, BigDecimal charterCapital,
                   Integer employeeCount, BigDecimal floorArea, String officeAddress,
                   String phoneNumber, String taxCode) {
        this.companyName = companyName;
        this.businessField = businessField;
        this.charterCapital = charterCapital;
        this.employeeCount = employeeCount;
        this.floorArea = floorArea;
        this.officeAddress = officeAddress;
        this.phoneNumber = phoneNumber;
        this.taxCode = taxCode;
    }

    // Getters and Setters
    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getBusinessField() { return businessField; }
    public void setBusinessField(String businessField) { this.businessField = businessField; }

    public BigDecimal getCharterCapital() { return charterCapital; }
    public void setCharterCapital(BigDecimal charterCapital) { this.charterCapital = charterCapital; }

    public Integer getEmployeeCount() { return employeeCount; }
    public void setEmployeeCount(Integer employeeCount) { this.employeeCount = employeeCount; }

    public BigDecimal getFloorArea() { return floorArea; }
    public void setFloorArea(BigDecimal floorArea) { this.floorArea = floorArea; }

    public String getOfficeAddress() { return officeAddress; }
    public void setOfficeAddress(String officeAddress) { this.officeAddress = officeAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getTaxCode() { return taxCode; }
    public void setTaxCode(String taxCode) { this.taxCode = taxCode; }

    // equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyId, company.companyId) &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(businessField, company.businessField) &&
                Objects.equals(charterCapital, company.charterCapital) &&
                Objects.equals(employeeCount, company.employeeCount) &&
                Objects.equals(floorArea, company.floorArea) &&
                Objects.equals(officeAddress, company.officeAddress) &&
                Objects.equals(phoneNumber, company.phoneNumber) &&
                Objects.equals(taxCode, company.taxCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, businessField, charterCapital, employeeCount,
                floorArea, officeAddress, phoneNumber, taxCode);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", businessField='" + businessField + '\'' +
                ", charterCapital=" + charterCapital +
                ", employeeCount=" + employeeCount +
                ", floorArea=" + floorArea +
                ", officeAddress='" + officeAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", taxCode='" + taxCode + '\'' +
                '}';
    }
}
