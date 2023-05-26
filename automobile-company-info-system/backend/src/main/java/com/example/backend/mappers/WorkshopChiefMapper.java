package com.example.backend.mappers;


import com.example.backend.dto.WorkshopChiefDTO;
import com.example.backend.entity.WorkshopChief;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, WorkshopMapper.class})
public interface WorkshopChiefMapper {
    WorkshopChiefDTO toDTO(WorkshopChief workshopChief);

//    WorkshopChief toWorkshopChief(WorkshopChiefDTO workshopChiefDTO);
}
