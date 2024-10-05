package com.example.office_management.repositories;

import com.example.office_management.models.AccessHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessHistoryRepository extends JpaRepository<AccessHistory, Long> {
}