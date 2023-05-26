package com.example.backend.repository;

import com.example.backend.entity.WorkshopChief;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopChiefRepo extends CrudRepository<WorkshopChief, Long>, JpaSpecificationExecutor<WorkshopChief> {
}
