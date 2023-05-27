package com.example.backend.controller;

import com.example.backend.dto.front.CargoTransportationFrontDTO;
import com.example.backend.service.CargoTransportationService;
import com.example.backend.service.TruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicles/trucks/trucking")
public class CargoTransportationController {

        private final CargoTransportationService cargoTransportationService;

        @PostMapping
        public ResponseEntity create(CargoTransportationFrontDTO cargo){
            try {
                return ResponseEntity.ok(cargoTransportationService.create(cargo));
            } catch (NoSuchElementException | IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
        @PutMapping
        public ResponseEntity update(@RequestBody CargoTransportationFrontDTO cargo){
            try {
                return ResponseEntity.ok(cargoTransportationService.update(cargo));
            } catch (NoSuchElementException | IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping
        public ResponseEntity delete(@RequestParam Long id){
            return ResponseEntity.ok(cargoTransportationService.deleteById(id));
        }
        @GetMapping
        public ResponseEntity getAll(){
            return ResponseEntity.ok(cargoTransportationService.getAll());
        }

        @GetMapping("/fields")
        public ResponseEntity sendFields(){
            return ResponseEntity.ok(cargoTransportationService.sendFields());
        }
}
