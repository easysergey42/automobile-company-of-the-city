package com.example.backend.dto.front;

import com.example.backend.dto.RouteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusFrontDTO extends VehicleFrontDTO{
    private Long passengersCapacity;
    private String routeName;
}
