package com.example.backend.mappers;


import com.example.backend.dto.RepairDTO;
import com.example.backend.entity.Repair;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RepairComponentMapper.class, VehicleMapper.class, TeamMapper.class})
public interface RepairMapper {

    @Mapping(target = "price", source = "repairPrice")
    @Mapping(target = "date", source = "repairDate")
    @Mapping(target = "repairersTeam", source = "team")
    RepairDTO toDTO(Repair repair);



}
