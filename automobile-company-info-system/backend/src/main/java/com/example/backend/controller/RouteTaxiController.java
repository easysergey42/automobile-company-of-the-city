package com.example.backend.controller;

import com.example.backend.dto.front.RouteTaxiFrontDTO;
import com.example.backend.service.RouteTaxiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles/routeTaxis")
public class RouteTaxiController {

    private final RouteTaxiService routeTaxiService;

    @PostMapping
    public ResponseEntity create(@RequestBody RouteTaxiFrontDTO routeTaxiFrontDTO){
        try {
            return ResponseEntity.ok(routeTaxiService.create(routeTaxiFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody RouteTaxiFrontDTO routeTaxiFrontDTO){
        try {
            return ResponseEntity.ok(routeTaxiService.update(routeTaxiFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        return ResponseEntity.ok(routeTaxiService.deleteById(id));
    }
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(routeTaxiService.getAll());
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(routeTaxiService.sendFields());
    }
}
