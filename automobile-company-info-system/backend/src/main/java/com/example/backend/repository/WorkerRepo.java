package com.example.backend.repository;

import com.example.backend.entity.Worker;
import com.example.backend.repository.interfaces.TestWorker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkerRepo extends CrudRepository<Worker, Long> {

    @Query(
            value = "Select spec , person_id as personId, team_id as teamId from Worker where id = :#{#id}", nativeQuery = true
    )
    List<TestWorker> oleg(@Param("id") Long id);


    @Query(
            value = "Select spec , person_id as personId, team_id as teamId from Worker", nativeQuery = true
    )
    List<TestWorker> dima();
}
