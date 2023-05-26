package com.example.backend.repository;

import com.example.backend.entity.GarageEconomy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GarageEconomyRepo extends CrudRepository<GarageEconomy, Long> {
    Optional<GarageEconomy> findByAddress(String address);
}
