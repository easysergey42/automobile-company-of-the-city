package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusDTO extends VehicleDTO{
    private Long passengersCapacity;
    private RouteDTO route;
}
