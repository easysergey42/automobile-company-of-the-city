package com.example.backend.service;

import com.example.backend.dto.VehicleDTO;
import com.example.backend.dto.front.BusFrontDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.entity.Bus;
import com.example.backend.entity.GarageEconomy;
import com.example.backend.entity.Route;
import com.example.backend.entity.Vehicle;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.repository.BusRepo;
import com.example.backend.repository.GarageEconomyRepo;
import com.example.backend.repository.RouteRepo;
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
public class BusService {
    private final BusRepo busRepo;
    private final GarageEconomyRepo garageEconomyRepo;
    private final RouteRepo routeRepo;
    private final VehicleRepo vehicleRepo;


    private static Set<String> geTypes = Set.of("garage box", "garage", "workshop area");
    private static String validate(String geType){
        if (geTypes.contains(geType)) return geType;
        throw new IllegalArgumentException("Not a garage economy type");
    }

    @Transactional
    public BusFrontDTO create(@NonNull BusFrontDTO request){
        Bus vehicle = new Bus();
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
        var route = routeRepo.findByRouteName(request.getRouteName());
        if (route.isPresent())
            vehicle.setRoute(route.get());
        else{
            Route newRoute = new Route();
            newRoute.setRouteName(request.getRouteName());
            vehicle.setRoute(routeRepo.save( newRoute));
        }
        vehicle.setMileage(request.getMileage());
        vehicle.setModel(request.getModel());
        vehicle.setNumber(request.getNumber());
        vehicle.setAcquireDate(request.getAcquireDate());
        vehicle.setWriteOffDate(request.getWriteOffDate());
        vehicle.setPassengersCapacity(request.getPassengersCapacity());

        return FrontMapper.toBusFrontDTO(busRepo.save(vehicle));
    }

    @Transactional
    public BusFrontDTO update(@NonNull BusFrontDTO request){
        Bus vehicle = busRepo.findById(request.getId()).get();
        vehicle.setMileage(request.getMileage());
        vehicle.setModel(request.getModel());
        vehicle.setNumber(request.getNumber());
        vehicle.setAcquireDate(request.getAcquireDate());
        vehicle.setWriteOffDate(request.getWriteOffDate());
        vehicle.setPassengersCapacity(request.getPassengersCapacity());
        GarageEconomy garageEconomy = vehicle.getLocation();
        garageEconomy.setAddress(request.getAddress());
        garageEconomy.setGeType(validate(request.getGeType()));
        Route route = vehicle.getRoute();
        route.setRouteName(request.getRouteName());
        return FrontMapper.toBusFrontDTO(busRepo.save(vehicle));
    }

    @Transactional
    public Long deleteById(Long id){
        vehicleRepo.deleteById(id);
        return id;
    }
    @Transactional
    public List<BusFrontDTO> getAll(){
        List<Bus> vehicles = new ArrayList<>();
        busRepo.findAll().forEach(vehicles::add);
        return vehicles.stream()
                .map(FrontMapper::toBusFrontDTO)
                .collect(Collectors.toList());
    }



    public List<String> sendFields(){
        List<String> fields = Arrays.stream(VehicleFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                filter((s)->s!="vehicleType").
                filter((s)->s!="id").
                collect(Collectors.toList());
        fields.addAll(Arrays.stream(BusFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                collect(Collectors.toList()));
        return fields;
    }
}
