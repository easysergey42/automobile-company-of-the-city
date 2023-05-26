package com.example.backend.mappers;

import com.example.backend.dto.TeamLeaderDTO;
import com.example.backend.entity.TeamLeader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MasterMapper.class})
public interface TeamLeaderMapper {
    @Mapping(target = "id", source = "id")
    TeamLeaderDTO toDTO(TeamLeader teamLeader);
}
