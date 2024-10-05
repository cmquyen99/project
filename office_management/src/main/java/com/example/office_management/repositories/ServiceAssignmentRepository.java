package com.example.office_management.repositories;

import com.example.office_management.models.ServiceAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceAssignmentRepository extends JpaRepository<ServiceAssignment, Long> {
}