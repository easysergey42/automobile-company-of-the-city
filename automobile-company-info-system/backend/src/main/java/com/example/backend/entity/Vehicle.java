package com.example.backend.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.jdbc.Work;
import org.mapstruct.Mapping;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date acquireDate;
    private Date writeOffDate;
    private Long mileage;
    private String model;
    private String number;

    @ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    private GarageEconomy location;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "vehicledriver",
            joinColumns = @JoinColumn(name="vehicle_id"),
            inverseJoinColumns = @JoinColumn(name="driver_id")
    )
    private Set<Worker> drivers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Repair> repairs;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<MileageSnapshot> mileageSnapshots;

    public void removeDriver(Worker driver){
        this.drivers.remove(driver);
        driver.getVehicles().remove(this);
    }
}
