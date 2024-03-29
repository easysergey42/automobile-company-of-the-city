package com.example.backend.repository;

import com.example.backend.entity.Truck;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TruckRepo extends CrudRepository<Truck, Long>, JpaSpecificationExecutor<Truck> {
}
