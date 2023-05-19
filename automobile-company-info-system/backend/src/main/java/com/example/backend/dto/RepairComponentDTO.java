package com.example.backend.dto;

import com.example.backend.entity.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepairComponentDTO {
    private WorkerDTO repairer;
    private ComponentDTO component;
    private RepairDTO repair;
}
