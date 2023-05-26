package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TruckDTO extends VehicleDTO{
    private List<CargoTransportationDTO> trucking;
}
