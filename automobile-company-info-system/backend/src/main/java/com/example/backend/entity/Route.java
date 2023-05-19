package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private long id;

    private String routeName;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "route",
            fetch = FetchType.LAZY
    )
    private Set<Bus> buses;
}
