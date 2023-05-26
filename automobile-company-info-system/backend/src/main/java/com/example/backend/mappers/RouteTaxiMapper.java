package com.example.backend.mappers;

import com.example.backend.dto.RouteTaxiDTO;
import com.example.backend.entity.RouteTaxi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {VehicleMapper.class, RouteMapper.class} )
public interface RouteTaxiMapper {
    RouteTaxiDTO toDTO(RouteTaxi routeTaxi);

}
