package com.example.backend.mappers;

import com.example.backend.dto.MasterDTO;
import com.example.backend.entity.Master;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, WorkshopChiefMapper.class})
public interface MasterMapper {
    MasterDTO toDTO(Master master);

//    Master toMaster(MasterDTO masterDTO);
}
