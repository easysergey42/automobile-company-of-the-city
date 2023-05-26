package com.example.backend.controller;

import com.example.backend.dto.front.WorkerFrontDTO;
import com.example.backend.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerController{
    private final WorkerService workerService;

    @PostMapping
    public ResponseEntity create(@RequestBody WorkerFrontDTO workerFrontDTO){
        try {
            return ResponseEntity.ok(workerService.create(workerFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(workerService.getAll());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody WorkerFrontDTO workerFrontDTO){
        try {
            return ResponseEntity.ok(workerService.update(workerFrontDTO));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteWorker(@RequestParam Long id){
        return ResponseEntity.ok(workerService.deleteById(id));
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(workerService.sendFields());
    }
}
