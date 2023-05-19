package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "person_id")
public class WorkshopChief extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

}