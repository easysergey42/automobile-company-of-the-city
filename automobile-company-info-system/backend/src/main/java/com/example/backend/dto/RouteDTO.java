package com.example.backend.dto;

import com.example.backend.entity.RouteTaxi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteDTO {
    private Long id;
    private String routeName;

//    private List<BusDTO> buses;
//    private List<RouteTaxiDTO> routeTaxis;
}
