package com.example.backend.mappers;

import com.example.backend.dto.VehicleDTO;
import com.example.backend.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleMapper {
    VehicleDTO toDTO(Vehicle vehicle);
    List<VehicleDTO> toDTOs(List<Vehicle> vehicles);
}
