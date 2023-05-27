package com.example.backend.service;

import com.example.backend.dto.front.RouteTaxiFrontDTO;
import com.example.backend.dto.front.TruckFrontDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.entity.GarageEconomy;
import com.example.backend.entity.Truck;
import com.example.backend.entity.Vehicle;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.mappers.VehicleMapper;
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
public class TruckService {

    private final VehicleRepo vehicleRepo;
    private final GarageEconomyRepo garageEconomyRepo;
    private final TruckRepo truckRepo;

    private static Set<String> geTypes = Set.of("garage box", "garage", "workshop area");
    private static String validate(String geType){
        if (geTypes.contains(geType)) return geType;
        throw new IllegalArgumentException("Not a garage economy type");
    }

    @Transactional
    public TruckFrontDTO create(@NonNull TruckFrontDTO request){
        var truck = new Truck();
        var garageEconomy = garageEconomyRepo.findByAddress(request.getAddress());
        if (garageEconomy.isPresent()) {
            truck.setLocation(garageEconomy.get());
            garageEconomy.get().setGeType(validate(request.getGeType()));
        }
        else{
            GarageEconomy newGE = new GarageEconomy();
            newGE.setAddress(request.getAddress());
            newGE.setGeType(validate(request.getGeType()));
//            newGE.setVehicles(List.of(vehicle));
            truck.setLocation(garageEconomyRepo.save(newGE));
        }
        truck.setMileage(request.getMileage());
        truck.setModel(request.getModel());
        truck.setNumber(request.getNumber());
        truck.setAcquireDate(request.getAcquireDate());
        truck.setWriteOffDate(request.getWriteOffDate());

        return FrontMapper.toTruckFrontDTO(truckRepo.save(truck));
    }

    @Transactional
    public TruckFrontDTO update(@NonNull TruckFrontDTO request){
        Truck vehicle = truckRepo.findById(request.getId()).get();
        vehicle.setMileage(request.getMileage());
        vehicle.setModel(request.getModel());
        vehicle.setNumber(request.getNumber());
        vehicle.setAcquireDate(request.getAcquireDate());
        vehicle.setWriteOffDate(request.getWriteOffDate());
        GarageEconomy garageEconomy = vehicle.getLocation();
        garageEconomy.setAddress(request.getAddress());
        garageEconomy.setGeType(validate(request.getGeType()));

        return FrontMapper.toTruckFrontDTO((vehicleRepo.save(vehicle)));
    }

    @Transactional
    public Long deleteById(Long id){
        var vehicle = truckRepo.findById(id);
        if(vehicle.isEmpty()) return id;

//        vehicle.get().getDrivers().remove();
        truckRepo.deleteById(id);
        return id;
    }
    @Transactional
    public List<TruckFrontDTO> getAll(){
        List<Truck> vehicles = new ArrayList<>();
        truckRepo.findAll().forEach(vehicles::add);

        return vehicles.stream()
                .map(FrontMapper::toTruckFrontDTO)
                .collect(Collectors.toList());
    }



    public List<String> sendFields(){
        List<String> fields = Arrays.stream(VehicleFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                filter((s)->s!="vehicleType").
                filter((s)->s!="id").
                collect(Collectors.toList());
        fields.addAll(Arrays.stream(TruckFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                collect(Collectors.toList()));
        return fields;
    }
}
