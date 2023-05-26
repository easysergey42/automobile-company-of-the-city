package com.example.backend.mappers;


import com.example.backend.dto.SpecialEquipmentVehicleDTO;
import com.example.backend.entity.SpecialEquipmentVehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VehicleMapper.class)
public interface SpecialEquipmentVehicleMapper {
    SpecialEquipmentVehicleDTO toDTO(SpecialEquipmentVehicle specialEquipmentVehicle);
}
