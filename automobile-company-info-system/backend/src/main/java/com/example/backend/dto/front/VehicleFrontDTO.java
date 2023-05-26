package com.example.backend.dto.front;


import com.example.backend.dto.GarageEconomyDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleFrontDTO {
    private Long id;
    private Date acquireDate;
    private Date writeOffDate;
    private Long mileage;
    private String model;
    private String number;
//    private GarageEconomyDTO location;
    private String address;
    private String geType;

    private String vehicleType;
}
