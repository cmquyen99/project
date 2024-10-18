package com.example.office_management.controllers;

import com.example.office_management.models.AccessCard;
import com.example.office_management.services.AccessCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/access-cards")
@CrossOrigin(origins = "http://localhost:8234")
public class AccessCardController {
    @Autowired
    private AccessCardService accessCardService;

    @GetMapping
    public List<AccessCard> getAllAccessCards() {
        return accessCardService.getAllAccessCards();
    }

}