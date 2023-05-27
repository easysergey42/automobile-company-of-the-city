package com.example.backend.service;

import com.example.backend.dto.front.RepairFrontDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.entity.GarageEconomy;
import com.example.backend.entity.Repair;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.repository.RepairRepo;
import com.example.backend.repository.TeamRepo;
import com.example.backend.repository.VehicleRepo;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepairService {
    private final RepairRepo repairRepo;
    private final TeamRepo teamRepo;
    private final VehicleRepo vehicleRepo;

    @Transactional
    public RepairFrontDTO create(@NonNull RepairFrontDTO request){
        var repair = new Repair();
        repair.setRepairPrice(request.getPrice());
        repair.setRepairDate(request.getDate());
        repair.setTeam(teamRepo.findById(request.getRepairersTeam()).get());
        repair.setVehicle(vehicleRepo.findById(request.getVehicle()).get());

        return FrontMapper.toRepairFrontDTO(repairRepo.save(repair));
    }

    @Transactional
    public RepairFrontDTO update(@NonNull RepairFrontDTO request){
        Repair repair = repairRepo.findById(request.getId()).get();
        repair.setRepairPrice(request.getPrice());
        repair.setRepairDate(request.getDate());
        repair.setTeam(teamRepo.findById(request.getRepairersTeam()).get());
        repair.setVehicle(vehicleRepo.findById(request.getVehicle()).get());

        return FrontMapper.toRepairFrontDTO((repairRepo.save(repair)));
    }

    @Transactional
    public Long deleteById(Long id){
        var vehicle = repairRepo.findById(id);
        if(vehicle.isEmpty()) return id;

//        vehicle.get().getDrivers().remove();
        repairRepo.deleteById(id);
        return id;
    }
    @Transactional
    public List<RepairFrontDTO> getAll(){
        List<Repair> repairs = new ArrayList<>();
        repairRepo.findAll().forEach(repairs::add);

        return repairs.stream()
                .map(FrontMapper::toRepairFrontDTO)
                .collect(Collectors.toList());
    }



    public List<String> sendFields(){
        return Arrays.stream(RepairFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                collect(Collectors.toList());
    }
}
