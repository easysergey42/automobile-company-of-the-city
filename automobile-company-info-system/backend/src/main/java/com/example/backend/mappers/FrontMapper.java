package com.example.backend.mappers;

import com.example.backend.dto.VehicleDTO;
import com.example.backend.dto.WorkerDTO;
import com.example.backend.dto.front.BusFrontDTO;
import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.dto.front.WorkerFrontDTO;
import com.example.backend.entity.Bus;

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
        vehicle.setGeType(vehicleDTO.getLocation().getGeType());
        return vehicle;
    }

    public static BusFrontDTO toBusFrontDTO(Bus vehicleDTO){
        BusFrontDTO vehicle = new BusFrontDTO();
        vehicle.setId(vehicleDTO.getId());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setMileage(vehicleDTO.getMileage());
        vehicle.setNumber(vehicleDTO.getNumber());
        vehicle.setAcquireDate(vehicleDTO.getAcquireDate());
        vehicle.setWriteOffDate(vehicleDTO.getWriteOffDate());
        vehicle.setAddress(vehicleDTO.getLocation().getAddress());
        vehicle.setGeType(vehicleDTO.getLocation().getGeType());
        vehicle.setPassengersCapacity(vehicleDTO.getPassengersCapacity());
        vehicle.setRouteName(vehicleDTO.getRoute().getRouteName());
        vehicle.setVehicleType("автобус");
        return vehicle;
    }
}
