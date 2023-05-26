package com.example.backend.mappers;

import com.example.backend.dto.WorkshopDTO;
import com.example.backend.entity.Workshop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GarageEconomyMapper.class})
public interface WorkshopMapper {

    WorkshopDTO toDTO(Workshop workshop);

    Workshop toWorkshop(WorkshopDTO workshopDTO);

}
