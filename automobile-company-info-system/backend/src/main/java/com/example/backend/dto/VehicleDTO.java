package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDTO {
    private Long id;
    private Date acquireDate;
    private Date writeOffDate;
    private Long mileage;
    private String model;
    private String number;
    private GarageEconomyDTO location;
    private List<WorkerDTO> drivers;
//    private List<RepairDTO> repairs;
}
