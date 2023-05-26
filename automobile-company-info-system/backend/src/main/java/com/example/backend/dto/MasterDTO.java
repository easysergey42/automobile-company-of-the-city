package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MasterDTO extends PersonDTO {
    private WorkshopChiefDTO chief;
    private List<TeamLeaderDTO> teamLeaders;
}
