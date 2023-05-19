package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name="vehicle_id")
public class SpecialEquipmentVehicle extends Vehicle{
}
