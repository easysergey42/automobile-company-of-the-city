package com.example.backend.mappers;

import com.example.backend.dto.RepairComponentDTO;
import com.example.backend.entity.Repaircomponent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={WorkerMapper.class, RepairMapper.class})
public interface RepairComponentMapper {
    RepairComponentDTO toDTO(Repaircomponent repaircomponent);
}
