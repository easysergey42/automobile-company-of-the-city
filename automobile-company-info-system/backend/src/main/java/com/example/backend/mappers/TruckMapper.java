package com.example.backend.mappers;

import com.example.backend.dto.TruckDTO;
import com.example.backend.entity.Truck;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {VehicleMapper.class})
public interface TruckMapper {
    TruckDTO toDTO(Truck truck);
}
