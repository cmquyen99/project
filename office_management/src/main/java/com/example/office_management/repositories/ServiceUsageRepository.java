package com.example.office_management.repositories;

import com.example.office_management.models.Company;
import com.example.office_management.models.Services;
import com.example.office_management.models.ServiceUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ServiceUsageRepository extends JpaRepository<ServiceUsage, Long> {

}