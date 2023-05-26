package com.example.backend.mappers;

import com.example.backend.dto.VehicleDTO;
import com.example.backend.dto.WorkerDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.dto.front.WorkerFrontDTO;

public class FrontMapper {
    public static WorkerFrontDTO toWorkerFrontDTO(WorkerDTO workerDTO){
        WorkerFrontDTO worker = new WorkerFrontDTO();
        worker.setId(workerDTO.getId());
        worker.setSpec(workerDTO.getSpec());
        worker.setFirstName(workerDTO.getPerson().getFirstName());
        worker.setLastName(workerDTO.getPerson().getLastName());
        worker.setTeam(workerDTO.getTeam().getId());
        return worker;
    }

    public static VehicleFrontDTO toVehicleFrontDTO(VehicleDTO vehicleDTO){
        VehicleFrontDTO vehicle = new VehicleFrontDTO();
        vehicle.setId(vehicleDTO.getId());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setMileage(vehicleDTO.getMileage());
        vehicle.setNumber(vehicleDTO.getNumber());
        vehicle.setAcquireDate(vehicleDTO.getAcquireDate());
        vehicle.setWriteOffDate(vehicleDTO.getWriteOffDate());
        vehicle.setAddress(vehicleDTO.getLocation().getAddress());
        vehicle.setGarageEconomyType(vehicleDTO.getLocation().getGeType());
        return vehicle;
    }
}
