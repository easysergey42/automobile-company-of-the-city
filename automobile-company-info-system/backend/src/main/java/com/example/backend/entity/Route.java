package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long id;

    @Column(unique = true)
    private String routeName;

    @OneToMany(
            cascade = CascadeType.PERSIST,
            mappedBy = "route",
            fetch = FetchType.EAGER
    )
    private List<Bus> buses;

    @OneToMany(
            cascade = CascadeType.PERSIST,
            mappedBy = "route",
            fetch = FetchType.EAGER
    )
    private List<RouteTaxi> routeTaxis;
}
