package com.example.backend.mappers;

import com.example.backend.dto.TeamDTO;
import com.example.backend.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TeamLeaderMapper.class})
public interface TeamMapper {
    TeamDTO toDTO(Team team);

//    Team toTeam(TeamDTO teamDTO);

}
