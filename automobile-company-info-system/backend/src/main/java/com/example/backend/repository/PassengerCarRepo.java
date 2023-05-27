package com.example.backend.repository;


import com.example.backend.entity.PassengerCar;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerCarRepo extends CrudRepository<PassengerCar,Long>, JpaSpecificationExecutor<PassengerCar> {
}
