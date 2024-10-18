package com.example.office_management.repositories;

import com.example.office_management.models.AccessHistory;
import com.example.office_management.models.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccessHistoryRepository extends JpaRepository<AccessHistory, Long> {
    List<AccessHistory> findByCardEmployeeAndAccessTimeBetweenOrderByAccessTimeDesc(CompanyEmployee employee, LocalDateTime start, LocalDateTime end);

    @Query("SELECT DISTINCT ah.card.employee FROM AccessHistory ah")
    List<CompanyEmployee> findAllEmployeesWithAccessHistory();
}