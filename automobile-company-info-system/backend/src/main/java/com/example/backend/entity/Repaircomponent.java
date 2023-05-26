package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Repaircomponent {
    @Id
    @ManyToOne
    @JoinColumn(name = "repair_id")
    private Repair repair;

    @Id
    @ManyToOne
    @JoinColumn(name = "repairer_id")
    private Worker worker;

    private String component;
}
