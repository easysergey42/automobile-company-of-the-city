package com.example.backend.dto;

import com.example.backend.entity.enumtypes.GarageEconomyType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GarageEconomyDTO {
    private Long id;
    private GarageEconomyType geType;
    private String address;
}
