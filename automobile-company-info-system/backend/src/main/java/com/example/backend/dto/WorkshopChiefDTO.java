package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkshopChiefDTO extends PersonDTO {
    private WorkshopDTO workshop;
//    private List<MasterDTO> masters;
}
