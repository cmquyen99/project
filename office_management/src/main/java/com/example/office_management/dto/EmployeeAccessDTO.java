package com.example.office_management.dto;

import java.time.LocalDateTime;
import java.util.List;

public class EmployeeAccessDTO {
    private Long employeeId;
    private String employeeName;
    private String companyName;
    private List<AccessDetailDTO> accessDetails;

    // Constructors
    public EmployeeAccessDTO() {
    }

    public EmployeeAccessDTO(Long employeeId, String employeeName, String companyName, List<AccessDetailDTO> accessDetails) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.companyName = companyName;
        this.accessDetails = accessDetails;
    }

    // Getters and Setters
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<AccessDetailDTO> getAccessDetails() {
        return accessDetails;
    }

    public void setAccessDetails(List<AccessDetailDTO> accessDetails) {
        this.accessDetails = accessDetails;
    }

    public static class AccessDetailDTO {
        private LocalDateTime time;
        private String type; // "IN" or "OUT"
        private String location;

        // Constructors
        public AccessDetailDTO() {
        }

        public AccessDetailDTO(LocalDateTime time, String type, String location) {
            this.time = time;
            this.type = type;
            this.location = location;
        }

        // Getters and Setters
        public LocalDateTime getTime() {
            return time;
        }

        public void setTime(LocalDateTime time) {
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}