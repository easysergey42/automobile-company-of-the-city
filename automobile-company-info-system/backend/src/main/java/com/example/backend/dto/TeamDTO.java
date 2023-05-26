package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDTO {
    private Long id;
    private TeamLeaderDTO teamLeader;
//    private List<RepairDTO> repairs;
//    private List<WorkerDTO> workers;
}
