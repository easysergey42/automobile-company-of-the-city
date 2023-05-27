package com.example.backend.repository;

import com.example.backend.entity.CargoTransportation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoTransportationRepo extends CrudRepository<CargoTransportation, Long> {
}
