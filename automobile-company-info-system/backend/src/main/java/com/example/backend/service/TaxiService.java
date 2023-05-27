package com.example.backend.service;

import com.example.backend.dto.front.TaxiFrontDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.entity.GarageEconomy;
import com.example.backend.entity.Taxi;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.repository.GarageEconomyRepo;
import com.example.backend.repository.TaxiRepo;
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
public class TaxiService {

    private final VehicleRepo vehicleRepo;
    private final GarageEconomyRepo garageEconomyRepo;
    private final TaxiRepo taxiRepo;

    private static Set<String> geTypes = Set.of("garage box", "garage", "workshop area");
    private static String validate(String geType){
        if (geTypes.contains(geType)) return geType;
        throw new IllegalArgumentException("Not a garage economy type");
    }

    @Transactional
    public TaxiFrontDTO create(@NonNull TaxiFrontDTO request){
        var taxi = new Taxi();
        var garageEconomy = garageEconomyRepo.findByAddress(request.getAddress());
        if (garageEconomy.isPresent()) {
            taxi.setLocation(garageEconomy.get());
            garageEconomy.get().setGeType(validate(request.getGeType()));
        }
        else{
            GarageEconomy newGE = new GarageEconomy();
            newGE.setAddress(request.getAddress());
            newGE.setGeType(validate(request.getGeType()));
//            newGE.setVehicles(List.of(vehicle));
            taxi.setLocation(garageEconomyRepo.save(newGE));
        }
        taxi.setMileage(request.getMileage());
        taxi.setModel(request.getModel());
        taxi.setNumber(request.getNumber());
        taxi.setAcquireDate(request.getAcquireDate());
        taxi.setWriteOffDate(request.getWriteOffDate());

        return FrontMapper.toTaxiFrontDTO(taxiRepo.save(taxi));
    }

    @Transactional
    public TaxiFrontDTO update(@NonNull TaxiFrontDTO request){
        Taxi vehicle = taxiRepo.findById(request.getId()).get();
        vehicle.setMileage(request.getMileage());
        vehicle.setModel(request.getModel());
        vehicle.setNumber(request.getNumber());
        vehicle.setAcquireDate(request.getAcquireDate());
        vehicle.setWriteOffDate(request.getWriteOffDate());
        GarageEconomy garageEconomy = vehicle.getLocation();
        garageEconomy.setAddress(request.getAddress());
        garageEconomy.setGeType(validate(request.getGeType()));

        return FrontMapper.toTaxiFrontDTO((vehicleRepo.save(vehicle)));
    }

    @Transactional
    public Long deleteById(Long id){
        var vehicle = taxiRepo.findById(id);
        if(vehicle.isEmpty()) return id;

//        vehicle.get().getDrivers().remove();
        taxiRepo.deleteById(id);
        return id;
    }
    @Transactional
    public List<TaxiFrontDTO> getAll(){
        List<Taxi> vehicles = new ArrayList<>();
        taxiRepo.findAll().forEach(vehicles::add);

        return vehicles.stream()
                .map(FrontMapper::toTaxiFrontDTO)
                .collect(Collectors.toList());
    }



    public List<String> sendFields(){
        List<String> fields = Arrays.stream(VehicleFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                filter((s)->s!="vehicleType").
                filter((s)->s!="id").
                collect(Collectors.toList());
        fields.addAll(Arrays.stream(TaxiFrontDTO.class.getDeclaredFields()).
                map(Field::getName).
                collect(Collectors.toList()));
        return fields;
    }
}
