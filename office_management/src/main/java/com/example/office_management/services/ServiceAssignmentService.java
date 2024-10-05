package com.example.office_management.services;

import com.example.office_management.models.ServiceAssignment;
import com.example.office_management.repositories.ServiceAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceAssignmentService {
    @Autowired
    private ServiceAssignmentRepository serviceAssignmentRepository;

    public List<ServiceAssignment> getAllServiceAssignments() {
        return serviceAssignmentRepository.findAll();
    }

    public ServiceAssignment saveServiceAssignment(ServiceAssignment assignment) {
        return serviceAssignmentRepository.save(assignment);
    }
}