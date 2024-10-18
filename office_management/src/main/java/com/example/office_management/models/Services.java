package com.example.office_management.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private BigDecimal basePrice;
    private String serviceName;
    private String serviceType;


    // Constructors
    public Services() {}

    public Services(BigDecimal basePrice, String serviceName, String serviceType, boolean mandatory) {
        this.basePrice = basePrice;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    // Getters and setters
    public Long getServiceId() { return serviceId; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
    public BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(BigDecimal basePrice) { this.basePrice = basePrice; }
    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

}