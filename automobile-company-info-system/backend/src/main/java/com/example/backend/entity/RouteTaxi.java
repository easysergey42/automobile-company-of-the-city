package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name="vehicle_id")
public class RouteTaxi extends Vehicle{
    private Long passengersCapacity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route")
    private Route route;
}
