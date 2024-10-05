package com.example.office_management.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "access_history")
public class AccessHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessId;

    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    private String accessPoint;
    private LocalDateTime accessTime;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private AccessCard card;

    public enum AccessType {
        IN, OUT
    }

    // Getters and setters
    public Long getAccessId() { return accessId; }
    public void setAccessId(Long accessId) { this.accessId = accessId; }
    public AccessType getAccessType() { return accessType; }
    public void setAccessType(AccessType accessType) { this.accessType = accessType; }
    public String getAccessPoint() { return accessPoint; }
    public void setAccessPoint(String accessPoint) { this.accessPoint = accessPoint; }
    public LocalDateTime getAccessTime() { return accessTime; }
    public void setAccessTime(LocalDateTime accessTime) { this.accessTime = accessTime; }
    public AccessCard getCard() { return card; }
    public void setCard(AccessCard card) { this.card = card; }
}