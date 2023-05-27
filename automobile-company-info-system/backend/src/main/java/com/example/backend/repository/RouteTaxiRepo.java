package com.example.backend.repository;

import com.example.backend.entity.Bus;
import com.example.backend.entity.RouteTaxi;
import com.example.backend.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteTaxiRepo extends CrudRepository<RouteTaxi, Long>, JpaSpecificationExecutor<RouteTaxi> {
}
