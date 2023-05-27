package com.example.backend.controller;

import com.example.backend.dto.front.TaxiFrontDTO;
import com.example.backend.service.TaxiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vehicles/taxis")
public class TaxiController {
    private final TaxiService taxiService;

    @PostMapping
    public ResponseEntity create(@RequestBody TaxiFrontDTO taxiFrontDTO){
        try {
            return ResponseEntity.ok(taxiService.create(taxiFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody TaxiFrontDTO taxiFrontDTO){
        try {
            return ResponseEntity.ok(taxiService.update(taxiFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        return ResponseEntity.ok(taxiService.deleteById(id));
    }
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(taxiService.getAll());
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(taxiService.sendFields());
    }
}
