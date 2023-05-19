package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkshopDTO {
    private Long id;
    private GarageEconomyDTO area;
    private String workshopName;
}
