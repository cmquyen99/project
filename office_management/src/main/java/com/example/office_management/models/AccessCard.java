package com.example.office_management.models;

import jakarta.persistence.*;

@Entity
@Table(name = "access_card")
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private CompanyEmployee employee;

    // Getters and setters
    public Long getCardId() { return cardId; }
    public void setCardId(Long cardId) { this.cardId = cardId; }
    public CompanyEmployee getEmployee() { return employee; }
    public void setEmployee(CompanyEmployee employee) { this.employee = employee; }
}