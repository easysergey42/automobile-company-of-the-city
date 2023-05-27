package com.example.backend.dto.front;

import com.example.backend.dto.TeamDTO;
import com.example.backend.dto.VehicleDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepairFrontDTO {
    private Long id;
    private Long vehicle;
    private Long price;
    private Date date;
    private Long repairersTeam;
}
