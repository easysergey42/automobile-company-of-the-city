package com.example.backend.mappers;

import com.example.backend.dto.MasterDTO;
import com.example.backend.entity.Master;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {WorkshopChiefMapper.class}
)
public interface MasterMapper {
    MasterDTO toDTO(Master master);
}
