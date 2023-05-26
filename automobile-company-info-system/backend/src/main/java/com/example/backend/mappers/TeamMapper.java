package com.example.backend.mappers;

import com.example.backend.dto.TeamDTO;
import com.example.backend.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = TeamLeaderMapper.class)
public interface TeamMapper{
    TeamDTO toDTO(Team team);
}
