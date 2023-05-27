package com.example.backend.dto.front;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxiFrontDTO extends VehicleFrontDTO{
        }
