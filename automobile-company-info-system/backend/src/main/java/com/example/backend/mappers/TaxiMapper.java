package com.example.backend.mappers;

import com.example.backend.dto.TaxiDTO;
import com.example.backend.entity.Taxi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VehicleMapper.class)
public interface TaxiMapper {
    TaxiDTO toDTO(Taxi taxi);
}
