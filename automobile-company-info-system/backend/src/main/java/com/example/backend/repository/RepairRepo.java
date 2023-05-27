package com.example.backend.repository;

import com.example.backend.entity.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepo extends CrudRepository<Repair, Long> {
}
