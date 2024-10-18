package com.example.office_management.services;

import com.example.office_management.models.ServiceUsage;
import com.example.office_management.repositories.ServiceUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceUsageService {
    @Autowired
    private ServiceUsageRepository serviceUsageRepository;

    public List<ServiceUsage> getAllServiceUsages() {
        return serviceUsageRepository.findAll();
    }

    public ServiceUsage saveServiceUsage(ServiceUsage usage) {
        return serviceUsageRepository.save(usage);
    }

}