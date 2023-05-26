package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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

    @OneToMany(fetch = FetchType.LAZY)
    private List<Team> teams;
}
