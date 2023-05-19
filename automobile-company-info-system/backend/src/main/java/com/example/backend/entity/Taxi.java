package com.example.backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name="vehicle_id")
public class Taxi extends Vehicle{
    private Long passengersCapacity;
}
