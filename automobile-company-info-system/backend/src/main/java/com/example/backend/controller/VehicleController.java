package com.example.backend.controller;


import com.example.backend.dto.front.VehicleFrontDTO;
import com.example.backend.dto.front.WorkerFrontDTO;
import com.example.backend.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity create(@RequestBody VehicleFrontDTO vehicleFrontDTO){
        try {
            return ResponseEntity.ok(vehicleService.create(vehicleFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody VehicleFrontDTO vehicleFrontDTO){
        try {
            return ResponseEntity.ok(vehicleService.update(vehicleFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteWorker(@RequestParam Long id){
        return ResponseEntity.ok(vehicleService.deleteById(id));
    }
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(vehicleService.sendFields());
    }
}
