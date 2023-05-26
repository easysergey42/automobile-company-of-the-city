package com.example.backend.repository;

import com.example.backend.entity.TeamLeader;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TeamLeaderRepo extends CrudRepository<TeamLeader, Long>, JpaSpecificationExecutor<TeamLeader> {
}
