package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Timestamp;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CargoTransportationDTO {
    private TruckDTO truck;
    private Timestamp deliveredTime;
    private Long id;
    private Long cargoVolume;
    private Long distance;
}
