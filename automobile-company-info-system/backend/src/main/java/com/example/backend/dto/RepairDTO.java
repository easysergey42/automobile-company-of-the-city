package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepairDTO {
    private Long id;
    private VehicleDTO vehicle;
    private Long price;
    private Date date;
    private TeamDTO repairersTeam;

    private List<RepairComponentDTO> repairs;

}
