package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamLeaderDTO extends PersonDTO {
    private MasterDTO master;
//    private List<TeamDTO> teams;
}
