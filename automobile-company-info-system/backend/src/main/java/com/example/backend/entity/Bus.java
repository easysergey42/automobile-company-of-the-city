package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name="vehicle_id")
public class Bus extends Vehicle {
    private Long passengersCapacity;

    @ManyToOne
    @JoinColumn(name = "route")
    private Route route;
}
