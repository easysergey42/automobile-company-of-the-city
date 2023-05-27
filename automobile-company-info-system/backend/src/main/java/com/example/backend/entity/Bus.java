package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name="vehicle_id")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Bus extends Vehicle {
    private Long passengersCapacity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route")
    private Route route;
}
