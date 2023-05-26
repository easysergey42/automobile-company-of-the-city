package com.example.backend.service;

import com.example.backend.repository.GarageEconomyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GarageEconomyService {
    private final GarageEconomyRepo garageEconomyRepo;

}
