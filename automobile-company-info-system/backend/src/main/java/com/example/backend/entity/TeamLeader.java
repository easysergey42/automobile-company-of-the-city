package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;


@Entity
@Setter
@Getter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "person_id")
public class TeamLeader extends Person{

    @ManyToOne
    @JoinColumn(name = "master_id")
    private Master master;
}
