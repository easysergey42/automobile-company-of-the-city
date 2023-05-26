package com.example.backend.mappers;

import com.example.backend.dto.GarageEconomyDTO;
import com.example.backend.entity.GarageEconomy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GarageEconomyMapper {
    GarageEconomyDTO toDTO(GarageEconomy garageEconomy);

}
