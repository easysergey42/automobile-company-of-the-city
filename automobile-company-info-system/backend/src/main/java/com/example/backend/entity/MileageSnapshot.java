package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class MileageSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long mileage;
    private Timestamp snapshotAt;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
