package com.example.backend.service;


import com.example.backend.dto.VehicleDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.entity.Vehicle;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.mappers.VehicleMapper;
import com.example.backend.repository.VehicleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepo vehicleRepo;
    private final VehicleMapper vehicleMapper;

    @Transactional
    public List<VehicleFrontDTO> getAll(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicleRepo.findAll().forEach(vehicles::add);

        return vehicleMapper.toDTOs(vehicles).stream()
                .map(FrontMapper::toVehicleFrontDTO)
                .collect(Collectors.toList());
    }
}
