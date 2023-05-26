package com.example.backend.mappers;

import com.example.backend.dto.BusDTO;
import com.example.backend.entity.Bus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VehicleMapper.class)
public interface BusMapper {
    BusDTO toDTO(Bus bus);
}
