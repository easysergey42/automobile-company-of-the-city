package com.example.backend.controller;

import com.example.backend.dto.front.PassengerCarFrontDTO;
import com.example.backend.service.PassengerCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicles/passengerCars")
public class PassengerCarController {
    private final PassengerCarService passengerCarService;

    @PostMapping
    public ResponseEntity create(@RequestBody PassengerCarFrontDTO passengerCarFrontDTO){
        try {
            return ResponseEntity.ok(passengerCarService.create(passengerCarFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody PassengerCarFrontDTO passengerCarFrontDTO){
        try {
            return ResponseEntity.ok(passengerCarService.update(passengerCarFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        return ResponseEntity.ok(passengerCarService.deleteById(id));
    }
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(passengerCarService.getAll());
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(passengerCarService.sendFields());
    }
}
