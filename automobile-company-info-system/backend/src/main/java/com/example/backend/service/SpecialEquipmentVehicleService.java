package com.example.backend.service;

import com.example.backend.dto.front.SpecialEquipmentVehicleFrontDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.entity.GarageEconomy;
import com.example.backend.entity.SpecialEquipmentVehicle;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.repository.GarageEconomyRepo;
import com.example.backend.repository.SpecialEquipmentVehicleRepo;
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
public class SpecialEquipmentVehicleService {

    private final VehicleRepo vehicleRepo;
    private final GarageEconomyRepo garageEconomyRepo;
    private final SpecialEquipmentVehicleRepo specialEquipmentVehicleRepo;

    private static Set<String> geTypes = Set.of("garage box", "garage", "workshop area");
    private static String validate(String geType){
        if (geTypes.contains(geType)) return geType;
        throw new IllegalArgumentException("Not a garage economy type");
    }

    @Transactional
    public SpecialEquipmentVehicleFrontDTO create(@NonNull SpecialEquipmentVehicleFrontDTO request){
        var specialEquipmentVehicle = new SpecialEquipmentVehicle();
        var garageEconomy = garageEconomyRepo.findByAddress(request.getAddress());
        if (garageEconomy.isPresent()) {
            specialEquipmentVehicle.setLocation(garageEconomy.get());
            garageEconomy.get().setGeType(validate(request.getGeType()));
        }
        else{
            GarageEconomy newGE = new GarageEconomy();
            newGE.setAddress(request.getAddress());
            newGE.setGeType(validate(request.getGeType()));
//            newGE.setVehicles(List.of(vehicle));
            specialEquipmentVehicle.setLocation(garageEconomyRepo.save(newGE));
        }
        specialEquipmentVehicle.setMileage(request.getMileage());
        specialEquipmentVehicle.setModel(request.getModel());
        specialEquipmentVehicle.setNumber(request.getNumber());
        specialEquipmentVehicle.setAcquireDate(request.getAcquireDate());
        specialEquipmentVehicle.setWriteOffDate(request.getWriteOffDate());

        return FrontMapper.toSpecialEquipmentVehicleFrontDTO(specialEquipmentVehicleRepo.save(specialEquipmentVehicle));
    }

    @Transactional
    public SpecialEquipmentVehicleFrontDTO update(@NonNull SpecialEquipmentVehicleFrontDTO request){
        SpecialEquipmentVehicle vehicle = specialEquipmentVehicleRepo.findById(request.getId()).get();
        vehicle.setMileage(request.getMileage());
        vehicle.setModel(request.getModel());
        vehicle.setNumber(request.getNumber());
        vehicle.setAcquireDate(request.getAcquireDate());
        vehicle.setWriteOffDate(request.getWriteOffDate());
        GarageEconomy garageEconomy = vehicle.getLocation();
        garageEconomy.setAddress(request.getAddress());
        garageEconomy.setGeType(validate(request.getGeType()));

        return FrontMapper.toSpecialEquipmentVehicleFrontDTO((vehicleRepo.save(vehicle)));
    }

    @Transactional
    public Long deleteById(Long id){
        var vehicle = specialEquipmentVehicleRepo.findById(id);
        if(vehicle.isEmpty()) return id;

//        vehicle.get().getDrivers().remove();
        specialEquipmentVehicleRepo.deleteById(id);
        return id;
    }
    @Transactional
    public List<SpecialEquipmentVehicleFrontDTO> getAll(){
        List<SpecialEquipmentVehicle> vehicles = new ArrayList<>();
        specialEquipmentVehicleRepo.findAll().forEach(vehicles::add);

        return vehicles.stream()
                .map(FrontMapper::toSpecialEquipmentVehicleFrontDTO)
                .collect(Collectors.toList());
    }



    public List<String> sendFields(){
        List<String> fields = Arrays.stream(VehicleFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                filter((s)->s!="vehicleType").
                filter((s)->s!="id").
                collect(Collectors.toList());
        fields.addAll(Arrays.stream(SpecialEquipmentVehicleFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                collect(Collectors.toList()));
        return fields;
    }
}

