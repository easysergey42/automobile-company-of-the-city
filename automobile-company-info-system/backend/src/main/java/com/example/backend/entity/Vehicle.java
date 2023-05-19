package com.example.backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date acquireDate;
    private Date writeOffDate;
    private Long mileage;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private GarageEconomy location;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicle_type_id")
    private VehicleType vehicleType;

    @ManyToMany(mappedBy = "vehicles")
    private Set<Worker> drivers;
}
