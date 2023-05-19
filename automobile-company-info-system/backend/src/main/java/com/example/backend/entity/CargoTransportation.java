package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoTransportation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long cargoVolume;
    private long distance;
    private Timestamp deliveredTime;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;
}
