package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TruckDTO extends VehicleDTO{
    private Long loadCapacity;
}
