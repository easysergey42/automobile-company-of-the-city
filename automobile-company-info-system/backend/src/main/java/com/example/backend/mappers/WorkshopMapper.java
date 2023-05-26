package com.example.backend.mappers;

import com.example.backend.dto.WorkshopDTO;
import com.example.backend.entity.Workshop;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {GarageEconomyMapper.class})
public interface WorkshopMapper {
    WorkshopDTO toDTO(Workshop workshop);
    List<WorkshopDTO> toDTOs(List<Workshop> workshops);
}
