package com.example.backend.mappers;

import com.example.backend.dto.CargoTransportationDTO;
import com.example.backend.entity.CargoTransportation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses=TruckMapper.class)

public interface CargoTransportationMapper {
    CargoTransportationDTO toDTO(CargoTransportation cargoTransportation);
}
