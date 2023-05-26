package com.example.backend.mappers;

import com.example.backend.dto.PassengerCarDTO;
import com.example.backend.entity.PassengerCar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VehicleMapper.class)
public interface PassengerCarMapper {
    PassengerCarDTO toDTO(PassengerCar passengerCar);
}
