package com.example.backend.service;

import com.example.backend.dto.front.CargoTransportationFrontDTO;
import com.example.backend.dto.front.TruckFrontDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.entity.CargoTransportation;
import com.example.backend.entity.GarageEconomy;
import com.example.backend.entity.Truck;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.mappers.VehicleMapper;
import com.example.backend.repository.CargoTransportationRepo;
import com.example.backend.repository.GarageEconomyRepo;
import com.example.backend.repository.TruckRepo;
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
public class CargoTransportationService {


    private final CargoTransportationRepo cargoTransportationRepo;


    @Transactional
    public CargoTransportationFrontDTO create(@NonNull CargoTransportationFrontDTO request){
        var cargoTransportation = new CargoTransportation();
        cargoTransportation.setCargoVolume(request.getCargoVolume());
        cargoTransportation.setId(request.getId());
        cargoTransportation.setDistance(request.getDistance());
        cargoTransportation.setDeliveredTime(request.getDeliveredTime());

        return FrontMapper.toCargoTransportationFrontDTO((cargoTransportationRepo.save(cargoTransportation)));
    }

    @Transactional
    public CargoTransportationFrontDTO update(@NonNull CargoTransportationFrontDTO request){
        CargoTransportation cargoTransportation = cargoTransportationRepo.findById(request.getId()).get();
        cargoTransportation.setCargoVolume(request.getCargoVolume());
        cargoTransportation.setId(request.getId());
        cargoTransportation.setDistance(request.getDistance());
        cargoTransportation.setDeliveredTime(request.getDeliveredTime());

        return FrontMapper.toCargoTransportationFrontDTO((cargoTransportationRepo.save(cargoTransportation)));
    }

    @Transactional
    public Long deleteById(Long id){
        var vehicle = cargoTransportationRepo.findById(id);
        if(vehicle.isEmpty()) return id;

//        vehicle.get().getDrivers().remove();
        cargoTransportationRepo.deleteById(id);
        return id;
    }
    @Transactional
    public List<CargoTransportationFrontDTO> getAll(){
        List<CargoTransportation> vehicles = new ArrayList<>();

        cargoTransportationRepo.findAll().forEach(vehicles::add);

        return vehicles.stream()
                .map(FrontMapper::toCargoTransportationFrontDTO)
                .collect(Collectors.toList());
    }


    public List<String> sendFields(){
        return Arrays.stream(CargoTransportationFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                filter((s)->s!="vehicleType").
                collect(Collectors.toList());
    }
}
