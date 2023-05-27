package com.example.backend.controller;

import com.example.backend.dto.front.SpecialEquipmentVehicleFrontDTO;
import com.example.backend.service.SpecialEquipmentVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicles/specialEquipmentCars")
public class SpecialEquipmentVehicleController {
    private final SpecialEquipmentVehicleService specialEquipmentVehicleService;

    @PostMapping
    public ResponseEntity create(@RequestBody SpecialEquipmentVehicleFrontDTO specialEquipmentVehicleFrontDTO){
        try {
            return ResponseEntity.ok(specialEquipmentVehicleService.create(specialEquipmentVehicleFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody SpecialEquipmentVehicleFrontDTO specialEquipmentVehicleFrontDTO){
        try {
            return ResponseEntity.ok(specialEquipmentVehicleService.update(specialEquipmentVehicleFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        return ResponseEntity.ok(specialEquipmentVehicleService.deleteById(id));
    }
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(specialEquipmentVehicleService.getAll());
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(specialEquipmentVehicleService.sendFields());
    }
}

