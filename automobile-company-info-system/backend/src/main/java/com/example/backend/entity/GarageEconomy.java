package com.example.backend.entity;

import com.example.backend.entity.enumtypes.GarageEconomyType;
import jakarta.persistence.*;
import lombok.*;

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

    private String address;
    @Enumerated(EnumType.STRING)
    private GarageEconomyType geType;
}