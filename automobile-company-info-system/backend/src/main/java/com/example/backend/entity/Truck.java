package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name="vehicle_id")
public class Truck extends Vehicle{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truck", fetch= FetchType.EAGER)
    List<CargoTransportation> trucking;
}
