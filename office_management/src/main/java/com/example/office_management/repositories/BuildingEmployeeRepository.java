package com.example.office_management.repositories;

import com.example.office_management.models.BuildingEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingEmployeeRepository extends JpaRepository<BuildingEmployee, Long> {
}