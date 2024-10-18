package com.example.office_management.dto;

import java.math.BigDecimal;

public class CompanyCostDTO {
    private Long companyId;
    private String companyName;
    private BigDecimal cleaningCost;
    private BigDecimal cateringCost;
    private BigDecimal parkingCost;
    private BigDecimal securityCost;
    private BigDecimal maintenanceCost;
    private BigDecimal totalCost;

    public CompanyCostDTO(Long companyId, String companyName, BigDecimal cleaningCost,
                          BigDecimal cateringCost, BigDecimal parkingCost, BigDecimal securityCost,
                          BigDecimal maintenanceCost, BigDecimal totalCost) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.cleaningCost = cleaningCost;
        this.cateringCost = cateringCost;
        this.parkingCost = parkingCost;
        this.securityCost = securityCost;
        this.maintenanceCost = maintenanceCost;
        this.totalCost = totalCost;
    }

    // Getters and setters
    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public BigDecimal getCleaningCost() { return cleaningCost; }
    public void setCleaningCost(BigDecimal cleaningCost) { this.cleaningCost = cleaningCost; }

    public BigDecimal getCateringCost() { return cateringCost; }
    public void setCateringCost(BigDecimal cateringCost) { this.cateringCost = cateringCost; }

    public BigDecimal getParkingCost() { return parkingCost; }
    public void setParkingCost(BigDecimal parkingCost) { this.parkingCost = parkingCost; }

    public BigDecimal getSecurityCost() { return securityCost; }
    public void setSecurityCost(BigDecimal securityCost) { this.securityCost = securityCost; }

    public BigDecimal getMaintenanceCost() { return maintenanceCost; }
    public void setMaintenanceCost(BigDecimal maintenanceCost) { this.maintenanceCost = maintenanceCost; }

    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
}