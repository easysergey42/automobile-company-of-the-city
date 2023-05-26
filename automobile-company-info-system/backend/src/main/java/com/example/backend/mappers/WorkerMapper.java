package com.example.backend.mappers;

import com.example.backend.dto.WorkerDTO;
import com.example.backend.entity.Worker;
import org.hibernate.jdbc.Work;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

    @Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkerMapper {

    WorkerDTO toDTO(Worker worker);
    List<WorkerDTO> toDTOs(List<Worker> workers);

}
