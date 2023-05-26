package com.example.backend.mappers;

import com.example.backend.dto.WorkshopChiefDTO;
import com.example.backend.entity.WorkshopChief;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {WorkshopMapper.class,PersonMapper.class}
)
public interface WorkshopChiefMapper {
    WorkshopChiefDTO toDTO(WorkshopChief workshopChief);
    List<WorkshopChiefDTO> toDTOs(List<WorkshopChief> chiefs);
}
