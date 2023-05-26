package com.example.backend.repository;

import com.example.backend.entity.Worker;
import com.example.backend.entity.Workshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepo extends CrudRepository<Workshop, Long> {

}
