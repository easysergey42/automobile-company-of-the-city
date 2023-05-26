package com.example.backend.service;


import com.example.backend.dto.VehicleDTO;
import com.example.backend.dto.WorkerDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.dto.front.WorkerFrontDTO;
import com.example.backend.entity.GarageEconomy;
import com.example.backend.entity.Person;
import com.example.backend.entity.Vehicle;
import com.example.backend.entity.Worker;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.mappers.VehicleMapper;
import com.example.backend.repository.GarageEconomyRepo;
import com.example.backend.repository.VehicleRepo;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepo vehicleRepo;
    private final VehicleMapper vehicleMapper;
    private final GarageEconomyRepo garageEconomyRepo;

    private static Set<String> geTypes = Set.of("garage box", "garage", "workshop area");
    private static String validate(String geType){
        if (geTypes.contains(geType)) return geType;
        throw new IllegalArgumentException("Not a garage economy type");
    }

    @Transactional
    public VehicleFrontDTO create(@NonNull VehicleFrontDTO request){
        Vehicle vehicle = new Vehicle();
        var garageEconomy = garageEconomyRepo.findByAddress(request.getAddress());
        if (garageEconomy.isPresent()) {
            vehicle.setLocation(garageEconomy.get());
            garageEconomy.get().setGeType(validate(request.getGeType()));
        }
        else{
            GarageEconomy newGE = new GarageEconomy();
            newGE.setAddress(request.getAddress());
            newGE.setGeType(validate(request.getGeType()));
//            newGE.setVehicles(List.of(vehicle));
            vehicle.setLocation(garageEconomyRepo.save(newGE));
        }
        vehicle.setMileage(request.getMileage());
        vehicle.setModel(request.getModel());
        vehicle.setNumber(request.getNumber());
        vehicle.setAcquireDate(request.getAcquireDate());
        vehicle.setWriteOffDate(request.getWriteOffDate());

        return FrontMapper.toVehicleFrontDTO(vehicleMapper.toDTO(vehicleRepo.save(vehicle)));
    }

    @Transactional
    public VehicleFrontDTO update(@NonNull VehicleFrontDTO request){
        Vehicle vehicle = vehicleRepo.findById(request.getId()).get();
        vehicle.setMileage(request.getMileage());
        vehicle.setModel(request.getModel());
        vehicle.setNumber(request.getNumber());
        vehicle.setAcquireDate(request.getAcquireDate());
        vehicle.setWriteOffDate(request.getWriteOffDate());
        GarageEconomy garageEconomy = vehicle.getLocation();
        garageEconomy.setAddress(request.getAddress());
        garageEconomy.setGeType(validate(request.getGeType()));
        return FrontMapper.toVehicleFrontDTO(vehicleMapper.toDTO(vehicleRepo.save(vehicle)));
    }

    @Transactional
    public Long deleteById(Long id){
        var vehicle = vehicleRepo.findById(id);
        if(vehicle.isEmpty()) return id;

//        vehicle.get().getDrivers().remove();
        vehicleRepo.deleteById(id);
        return id;
    }
    @Transactional
    public List<VehicleFrontDTO> getAll(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicleRepo.findAll().forEach(vehicles::add);

        return vehicleMapper.toDTOs(vehicles).stream()
                .map(FrontMapper::toVehicleFrontDTO)
                .collect(Collectors.toList());
    }



    public List<String> sendFields(){
        return Arrays.stream(VehicleFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                filter((s)->s!="vehicleType").
                collect(Collectors.toList());
    }
}
