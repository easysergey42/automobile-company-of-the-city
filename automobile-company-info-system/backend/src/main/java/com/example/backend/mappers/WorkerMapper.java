package com.example.backend.mappers;

import com.example.backend.dto.WorkerDTO;
import com.example.backend.entity.Worker;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {TeamMapper.class, PersonMapper.class, RepairMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface WorkerMapper {
    WorkerDTO toDTO(Worker worker);
    @InheritInverseConfiguration
    Worker toWorker(WorkerDTO workerDTO);

    List<WorkerDTO> toDTOs(List<Worker> workers);
//    Worker toWorker(WorkerDTO workerDTO);
}
