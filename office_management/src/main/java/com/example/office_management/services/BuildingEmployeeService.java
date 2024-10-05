package com.example.office_management.services;

import com.example.office_management.models.BuildingEmployee;
import com.example.office_management.repositories.BuildingEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BuildingEmployeeService {
    @Autowired
    private BuildingEmployeeRepository buildingEmployeeRepository;

    public List<BuildingEmployee> getAllBuildingEmployees() {
        return buildingEmployeeRepository.findAll();
    }

    public BuildingEmployee saveBuildingEmployee(BuildingEmployee employee) {
        return buildingEmployeeRepository.save(employee);
    }
}