package com.example.backend.mappers;

import com.example.backend.dto.TeamLeaderDTO;
import com.example.backend.entity.TeamLeader;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, MasterMapper.class})
public interface TeamLeaderMapper {
    TeamLeaderDTO toDTO(TeamLeader teamLeader);

//    TeamLeader toTeamLeader(TeamLeaderDTO teamLeaderDTO);

}
