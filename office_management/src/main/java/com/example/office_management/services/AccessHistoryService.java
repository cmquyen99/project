package com.example.office_management.services;

import com.example.office_management.models.AccessHistory;
import com.example.office_management.repositories.AccessHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccessHistoryService {
    @Autowired
    private AccessHistoryRepository accessHistoryRepository;

    public List<AccessHistory> getAllAccessHistory() {
        return accessHistoryRepository.findAll();
    }

    public AccessHistory saveAccessHistory(AccessHistory accessHistory) {
        return accessHistoryRepository.save(accessHistory);
    }
}