package com.example.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Worker{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

//    @Enumerated(EnumType.STRING)
    private String spec;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "worker", fetch = FetchType.LAZY)
    List<Repaircomponent> repairs;

    @ManyToMany
    @JoinTable(
            name = "vehicledriver",
            joinColumns = @JoinColumn(name="driver_id"),
            inverseJoinColumns = @JoinColumn(name="vehicle_id")
    )
    private List<Vehicle> vehicles;
}
