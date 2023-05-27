package com.example.backend.controller;


import com.example.backend.dto.front.RepairFrontDTO;
import com.example.backend.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/repairs")
public class RepairController {
    private final RepairService repairService;
    @PostMapping
    public ResponseEntity create(@RequestBody RepairFrontDTO repairFrontDTO){
        try {
            return ResponseEntity.ok(repairService.create(repairFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody RepairFrontDTO repairFrontDTO){
        try {
            return ResponseEntity.ok(repairService.update(repairFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        return ResponseEntity.ok(repairService.deleteById(id));
    }
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(repairService.getAll());
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(repairService.sendFields());
    }
}
