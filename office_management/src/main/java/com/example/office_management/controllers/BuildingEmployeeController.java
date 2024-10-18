package com.example.office_management.controllers;

import com.example.office_management.models.BuildingEmployee;
import com.example.office_management.services.BuildingEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/building-employees")
@CrossOrigin(origins = "http://localhost:8234")
public class BuildingEmployeeController {
    @Autowired
    private BuildingEmployeeService buildingEmployeeService;

    @GetMapping
    public List<BuildingEmployee> getAllBuildingEmployees() {
        return buildingEmployeeService.getAllBuildingEmployees();
    }


}