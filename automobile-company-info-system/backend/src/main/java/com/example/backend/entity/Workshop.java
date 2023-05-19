package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workshopName;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private GarageEconomy areaId;
}