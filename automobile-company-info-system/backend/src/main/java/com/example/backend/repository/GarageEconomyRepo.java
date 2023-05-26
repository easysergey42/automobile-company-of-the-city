package com.example.backend.repository;

import com.example.backend.entity.GarageEconomy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageEconomyRepo extends CrudRepository<GarageEconomy, Long> {
}
