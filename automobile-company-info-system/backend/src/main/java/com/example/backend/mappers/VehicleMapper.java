package com.example.backend.mappers;


import com.example.backend.dto.VehicleDTO;
import com.example.backend.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {GarageEconomyMapper.class, WorkerMapper.class}
)
public interface VehicleMapper {

    @Mapping(source = "drivers", target = "drivers")
    VehicleDTO toDTO(Vehicle vehicle);

    List<VehicleDTO> toDTOs(List<Vehicle> vehicles);
}
