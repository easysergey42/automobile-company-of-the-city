package com.example.backend.service;

import com.example.backend.dto.front.PassengerCarFrontDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.entity.GarageEconomy;
import com.example.backend.entity.PassengerCar;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.mappers.VehicleMapper;
import com.example.backend.repository.GarageEconomyRepo;
import com.example.backend.repository.PassengerCarRepo;
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
public class PassengerCarService {

    private final VehicleRepo vehicleRepo;
    private final GarageEconomyRepo garageEconomyRepo;
    private final PassengerCarRepo passengerCarRepo;

    private static Set<String> geTypes = Set.of("garage box", "garage", "workshop area");
    private static String validate(String geType){
        if (geTypes.contains(geType)) return geType;
        throw new IllegalArgumentException("Not a garage economy type");
    }

    @Transactional
    public PassengerCarFrontDTO create(@NonNull PassengerCarFrontDTO request){
        var passengerCar = new PassengerCar();
        var garageEconomy = garageEconomyRepo.findByAddress(request.getAddress());
        if (garageEconomy.isPresent()) {
            passengerCar.setLocation(garageEconomy.get());
            garageEconomy.get().setGeType(validate(request.getGeType()));
        }
        else{
            GarageEconomy newGE = new GarageEconomy();
            newGE.setAddress(request.getAddress());
            newGE.setGeType(validate(request.getGeType()));
//            newGE.setVehicles(List.of(vehicle));
            passengerCar.setLocation(garageEconomyRepo.save(newGE));
        }
        passengerCar.setMileage(request.getMileage());
        passengerCar.setModel(request.getModel());
        passengerCar.setNumber(request.getNumber());
        passengerCar.setAcquireDate(request.getAcquireDate());
        passengerCar.setWriteOffDate(request.getWriteOffDate());

        return FrontMapper.toPassengerCarFrontDTO(passengerCarRepo.save(passengerCar));
    }

    @Transactional
    public PassengerCarFrontDTO update(@NonNull PassengerCarFrontDTO request){
        PassengerCar vehicle = passengerCarRepo.findById(request.getId()).get();
        vehicle.setMileage(request.getMileage());
        vehicle.setModel(request.getModel());
        vehicle.setNumber(request.getNumber());
        vehicle.setAcquireDate(request.getAcquireDate());
        vehicle.setWriteOffDate(request.getWriteOffDate());
        GarageEconomy garageEconomy = vehicle.getLocation();
        garageEconomy.setAddress(request.getAddress());
        garageEconomy.setGeType(validate(request.getGeType()));

        return FrontMapper.toPassengerCarFrontDTO((vehicleRepo.save(vehicle)));
    }

    @Transactional
    public Long deleteById(Long id){
        var vehicle = passengerCarRepo.findById(id);
        if(vehicle.isEmpty()) return id;

//        vehicle.get().getDrivers().remove();
        passengerCarRepo.deleteById(id);
        return id;
    }
    @Transactional
    public List<PassengerCarFrontDTO> getAll(){
        List<PassengerCar> vehicles = new ArrayList<>();
        passengerCarRepo.findAll().forEach(vehicles::add);

        return vehicles.stream()
                .map(FrontMapper::toPassengerCarFrontDTO)
                .collect(Collectors.toList());
    }



    public List<String> sendFields(){
        List<String> fields = Arrays.stream(VehicleFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                filter((s)->s!="vehicleType").
                filter((s)->s!="id").
                collect(Collectors.toList());
        fields.addAll(Arrays.stream(PassengerCarFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                collect(Collectors.toList()));
        return fields;
    }
}
