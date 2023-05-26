package com.example.backend.dto;

import com.example.backend.entity.Repaircomponent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkerDTO {
    private Long id;
    private PersonDTO person;
    private TeamDTO team;
    private String spec;

    private List<RepairComponentDTO> repairs;
}
