package com.example.backend.entity;


import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.Mapping;

import java.sql.Date;
import java.util.List;
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
    private String model;
    private String number;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private GarageEconomy location;


    @ManyToMany(mappedBy = "vehicles")
    private List<Worker> drivers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Repair> repairs;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<MileageSnapshot> mileageSnapshots;
}
