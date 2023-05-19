package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkshopChiefDTO extends PersonDTO {
    private WorkshopDTO workshop;
}
