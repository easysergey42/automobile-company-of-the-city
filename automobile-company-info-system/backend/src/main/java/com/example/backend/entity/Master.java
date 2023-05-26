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
public class Master extends Person{
    @ManyToOne
    @JoinColumn(name = "chief_id")
    private WorkshopChief chief;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "master")
    private List<TeamLeader> teamLeaders;
}
