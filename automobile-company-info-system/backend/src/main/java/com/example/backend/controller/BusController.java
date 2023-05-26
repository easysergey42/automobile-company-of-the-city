package com.example.backend.controller;

import com.example.backend.dto.front.BusFrontDTO;
import com.example.backend.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles/buses")
public class BusController {

    private final BusService busService;

    @PostMapping
    public ResponseEntity create(@RequestBody BusFrontDTO busFrontDTO){
        try {
            return ResponseEntity.ok(busService.create(busFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody BusFrontDTO busFrontDTO){
        try {
            return ResponseEntity.ok(busService.update(busFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        return ResponseEntity.ok(busService.deleteById(id));
    }
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(busService.getAll());
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(busService.sendFields());
    }
}
