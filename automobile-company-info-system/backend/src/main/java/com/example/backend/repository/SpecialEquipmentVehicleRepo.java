package com.example.backend.repository;

import com.example.backend.entity.SpecialEquipmentVehicle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialEquipmentVehicleRepo extends CrudRepository<SpecialEquipmentVehicle, Long>, JpaSpecificationExecutor<SpecialEquipmentVehicle> {
}
