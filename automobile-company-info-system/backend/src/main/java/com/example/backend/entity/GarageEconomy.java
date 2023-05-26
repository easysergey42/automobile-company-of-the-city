package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GarageEconomy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String geType;
    @Column(unique = true)
    private String address;

    @OneToMany(mappedBy = "location")
    private List<Vehicle> vehicles;
//    @Enumerated(EnumType.STRING)
}