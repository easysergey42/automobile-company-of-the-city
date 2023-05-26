package com.example.backend.mappers;

import com.example.backend.dto.GarageEconomyDTO;
import com.example.backend.entity.GarageEconomy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GarageEconomyMapper {
    GarageEconomyDTO toDTO(GarageEconomy garageEconomy);
}
