package com.example.backend.repository;

import com.example.backend.entity.Taxi;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepo extends CrudRepository<Taxi, Long>, JpaSpecificationExecutor<Taxi> {
}
