package com.example.backend.controller;

import com.example.backend.dto.front.TruckFrontDTO;
import com.example.backend.service.TruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles/trucks")
public class TruckController {

    private final TruckService truckService;

    @PostMapping
    public ResponseEntity create(@RequestBody TruckFrontDTO truckFrontDTO){
        try {
            return ResponseEntity.ok(truckService.create(truckFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody TruckFrontDTO truckFrontDTO){
        try {
            return ResponseEntity.ok(truckService.update(truckFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        return ResponseEntity.ok(truckService.deleteById(id));
    }
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(truckService.getAll());
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(truckService.sendFields());
    }
}
