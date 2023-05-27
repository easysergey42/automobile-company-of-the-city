package com.example.backend.repository.interfaces;

import com.example.backend.dto.GarageEconomyDTO;

import java.sql.Date;

public interface Query12 {
    Long getId();
    Date getAcquireDate();
    Date getWriteOffDate();
    Long getMileage();
    String getModel();
    String getNumber();
}
