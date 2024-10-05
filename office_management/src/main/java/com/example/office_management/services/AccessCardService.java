package com.example.office_management.services;

import com.example.office_management.models.AccessCard;
import com.example.office_management.repositories.AccessCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccessCardService {
    @Autowired
    private AccessCardRepository accessCardRepository;

    public List<AccessCard> getAllAccessCards() {
        return accessCardRepository.findAll();
    }

    public AccessCard saveAccessCard(AccessCard accessCard) {
        return accessCardRepository.save(accessCard);
    }
}