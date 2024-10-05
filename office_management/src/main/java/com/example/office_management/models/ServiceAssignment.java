package com.example.office_management.models;

import jakarta.persistence.*;

@Entity
@Table(name = "service_assignment")
public class ServiceAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private BuildingEmployee employee;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    // Getters and setters
    public Long getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }
    public BuildingEmployee getEmployee() { return employee; }
    public void setEmployee(BuildingEmployee employee) { this.employee = employee; }
    public Services getService() { return services; }
    public void setService(Services services) { this.services = services; }
}