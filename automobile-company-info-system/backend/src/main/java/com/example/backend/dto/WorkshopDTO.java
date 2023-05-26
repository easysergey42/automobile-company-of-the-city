package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkshopDTO {
    private Long id;
    private GarageEconomyDTO areaId;
    private String workshopName;

//    private List<WorkshopChiefDTO> chiefs;
}
