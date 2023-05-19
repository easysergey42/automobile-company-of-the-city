package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleTypeDTO {
    private Long id;
    private String brand;
    private String model;
}
