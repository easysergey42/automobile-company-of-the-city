package com.example.backend.dto.front;

import com.example.backend.dto.TruckDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Timestamp;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CargoTransportationFrontDTO {
    private Long id;
    private Long truck_id;
    private Timestamp deliveredTime;
    private Long cargoVolume;
    private Long distance;
}
