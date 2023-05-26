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
public class WorkshopChief extends Person{

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chief")
    private List<Master> masters;

}