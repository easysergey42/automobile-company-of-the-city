package com.example.backend.service;

import com.example.backend.dto.front.RouteTaxiFrontDTO;
import com.example.backend.entity.RouteTaxi;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.entity.GarageEconomy;
import com.example.backend.entity.Route;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.repository.*;
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
public class RouteTaxiService {
    private final RouteTaxiRepo routeTaxiRepo;
    private final GarageEconomyRepo garageEconomyRepo;
    private final RouteRepo routeRepo;
    private final VehicleRepo vehicleRepo;


    private static Set<String> geTypes = Set.of("garage box", "garage", "workshop area");
    private static String validate(String geType){
        if (geTypes.contains(geType)) return geType;
        throw new IllegalArgumentException("Not a garage economy type");
    }

    @Transactional
    public RouteTaxiFrontDTO create(@NonNull RouteTaxiFrontDTO request){
        var vehicle = new RouteTaxi();
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

        return FrontMapper.toRouteTaxiFrontDTO(routeTaxiRepo.save(vehicle));
    }

    @Transactional
    public RouteTaxiFrontDTO update(@NonNull RouteTaxiFrontDTO request){
        RouteTaxi vehicle = routeTaxiRepo.findById(request.getId()).get();
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
        return FrontMapper.toRouteTaxiFrontDTO(routeTaxiRepo.save(vehicle));
    }

    @Transactional
    public Long deleteById(Long id){
        routeTaxiRepo.deleteById(id);
        return id;
    }
    @Transactional
    public List<RouteTaxiFrontDTO> getAll(){
        List<RouteTaxi> vehicles = new ArrayList<>();
        routeTaxiRepo.findAll().forEach(vehicles::add);
        return vehicles.stream()
                .map(FrontMapper::toRouteTaxiFrontDTO)
                .collect(Collectors.toList());
    }



    public List<String> sendFields(){
        List<String> fields = Arrays.stream(VehicleFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                filter((s)->s!="vehicleType").
                filter((s)->s!="id").
                collect(Collectors.toList());
        fields.addAll(Arrays.stream(RouteTaxiFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                collect(Collectors.toList()));
        return fields;
    }
}
