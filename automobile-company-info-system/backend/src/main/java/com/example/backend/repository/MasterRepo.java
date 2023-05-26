package com.example.backend.repository;

import com.example.backend.entity.Master;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepo extends CrudRepository<Master, Long>, JpaSpecificationExecutor<Master> {
}
