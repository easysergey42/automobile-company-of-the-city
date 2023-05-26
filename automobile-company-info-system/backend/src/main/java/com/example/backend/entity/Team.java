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
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_leader_id")
    private TeamLeader teamLeader;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Worker> workers;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Repair> repairs;
}
