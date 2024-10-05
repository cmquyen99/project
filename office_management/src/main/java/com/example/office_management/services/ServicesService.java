package com.example.office_management.services;

import com.example.office_management.models.Services;
import com.example.office_management.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    public Services saveService(Services services) {
        return servicesRepository.save(services);
    }
}