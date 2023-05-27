package com.example.backend.mappers;

import com.example.backend.dto.VehicleDTO;
import com.example.backend.dto.WorkerDTO;
import com.example.backend.dto.front.*;
import com.example.backend.entity.*;

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

    public static BusFrontDTO toBusFrontDTO(Bus bus){
        BusFrontDTO vehicle = new BusFrontDTO();
        vehicle.setId(bus.getId());
        vehicle.setModel(bus.getModel());
        vehicle.setMileage(bus.getMileage());
        vehicle.setNumber(bus.getNumber());
        vehicle.setAcquireDate(bus.getAcquireDate());
        vehicle.setWriteOffDate(bus.getWriteOffDate());
        vehicle.setAddress(bus.getLocation().getAddress());
        vehicle.setGeType(bus.getLocation().getGeType());
        vehicle.setPassengersCapacity(bus.getPassengersCapacity());
        vehicle.setRouteName(bus.getRoute().getRouteName());
        vehicle.setVehicleType("автобус");
        return vehicle;
    }

    public static RouteTaxiFrontDTO toRouteTaxiFrontDTO(RouteTaxi routeTaxi){
        var vehicle = new RouteTaxiFrontDTO();
        vehicle.setId(routeTaxi.getId());
        vehicle.setModel(routeTaxi.getModel());
        vehicle.setMileage(routeTaxi.getMileage());
        vehicle.setNumber(routeTaxi.getNumber());
        vehicle.setAcquireDate(routeTaxi.getAcquireDate());
        vehicle.setWriteOffDate(routeTaxi.getWriteOffDate());
        vehicle.setAddress(routeTaxi.getLocation().getAddress());
        vehicle.setGeType(routeTaxi.getLocation().getGeType());
        vehicle.setPassengersCapacity(routeTaxi.getPassengersCapacity());
        vehicle.setRouteName(routeTaxi.getRoute().getRouteName());
        vehicle.setVehicleType("маршрутка");
        return vehicle;
    }

    public static TruckFrontDTO toTruckFrontDTO(Truck truck){

        var truckFrontDTO = new TruckFrontDTO();
        truckFrontDTO.setId(truck.getId());
        truckFrontDTO.setModel(truck.getModel());
        truckFrontDTO.setMileage(truck.getMileage());
        truckFrontDTO.setNumber(truck.getNumber());
        truckFrontDTO.setAcquireDate(truck.getAcquireDate());
        truckFrontDTO.setWriteOffDate(truck.getWriteOffDate());
        truckFrontDTO.setAddress(truck.getLocation().getAddress());
        truckFrontDTO.setGeType(truck.getLocation().getGeType());
        truckFrontDTO.setVehicleType("грузовик");
        return truckFrontDTO;
    }

    public static PassengerCarFrontDTO toPassengerCarFrontDTO(PassengerCar passengerCar){
        var passengerCarFrontDTO = new PassengerCarFrontDTO();
        passengerCarFrontDTO.setId(passengerCar.getId());
        passengerCarFrontDTO.setModel(passengerCar.getModel());
        passengerCarFrontDTO.setMileage(passengerCar.getMileage());
        passengerCarFrontDTO.setNumber(passengerCar.getNumber());
        passengerCarFrontDTO.setAcquireDate(passengerCar.getAcquireDate());
        passengerCarFrontDTO.setWriteOffDate(passengerCar.getWriteOffDate());
        passengerCarFrontDTO.setAddress(passengerCar.getLocation().getAddress());
        passengerCarFrontDTO.setGeType(passengerCar.getLocation().getGeType());
        passengerCarFrontDTO.setVehicleType("легковой автомобиль");
        return passengerCarFrontDTO;
    }

    public static TaxiFrontDTO toTaxiFrontDTO(Taxi taxi){
        var taxiFrontDTO = new TaxiFrontDTO();
        taxiFrontDTO.setId(taxi.getId());
        taxiFrontDTO.setModel(taxi.getModel());
        taxiFrontDTO.setMileage(taxi.getMileage());
        taxiFrontDTO.setNumber(taxi.getNumber());
        taxiFrontDTO.setAcquireDate(taxi.getAcquireDate());
        taxiFrontDTO.setWriteOffDate(taxi.getWriteOffDate());
        taxiFrontDTO.setAddress(taxi.getLocation().getAddress());
        taxiFrontDTO.setGeType(taxi.getLocation().getGeType());
        taxiFrontDTO.setVehicleType("такси");
        return taxiFrontDTO;
    }

    public static SpecialEquipmentVehicleFrontDTO toSpecialEquipmentVehicleFrontDTO(SpecialEquipmentVehicle specialEquipmentVehicle){
        var specialEquipmentVehicleFrontDTO = new SpecialEquipmentVehicleFrontDTO();
        specialEquipmentVehicleFrontDTO.setId(specialEquipmentVehicle.getId());
        specialEquipmentVehicleFrontDTO.setModel(specialEquipmentVehicle.getModel());
        specialEquipmentVehicleFrontDTO.setMileage(specialEquipmentVehicle.getMileage());
        specialEquipmentVehicleFrontDTO.setNumber(specialEquipmentVehicle.getNumber());
        specialEquipmentVehicleFrontDTO.setAcquireDate(specialEquipmentVehicle.getAcquireDate());
        specialEquipmentVehicleFrontDTO.setWriteOffDate(specialEquipmentVehicle.getWriteOffDate());
        specialEquipmentVehicleFrontDTO.setAddress(specialEquipmentVehicle.getLocation().getAddress());
        specialEquipmentVehicleFrontDTO.setGeType(specialEquipmentVehicle.getLocation().getGeType());
        specialEquipmentVehicleFrontDTO.setVehicleType("вспомогательный транспорт");
        return specialEquipmentVehicleFrontDTO;
    }

    public static CargoTransportationFrontDTO toCargoTransportationFrontDTO(CargoTransportation cargoTransportation){
        var cargo = new CargoTransportationFrontDTO();
        cargo.setId(cargoTransportation.getId());
        cargo.setCargoVolume(cargoTransportation.getCargoVolume());
        cargo.setDistance(cargoTransportation.getDistance());
        cargo.setDeliveredTime(cargoTransportation.getDeliveredTime());
        cargo.setTruck_id(cargoTransportation.getTruck().getId());
        return cargo;
    }

    public static RepairFrontDTO toRepairFrontDTO(Repair repair){
        var repairFrontDTO = new RepairFrontDTO();
        repairFrontDTO.setId(repair.getId());
        repairFrontDTO.setVehicle(repair.getVehicle().getId());
        repairFrontDTO.setRepairersTeam(repair.getTeam().getId());
        repairFrontDTO.setPrice(repair.getRepairPrice());
        repairFrontDTO.setDate(repair.getRepairDate());
        return repairFrontDTO;
    }

}
