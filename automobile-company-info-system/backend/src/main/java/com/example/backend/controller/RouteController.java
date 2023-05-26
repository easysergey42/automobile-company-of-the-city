package com.example.backend.controller;


import com.example.backend.dto.RouteDTO;
import com.example.backend.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;

    @PostMapping()
    public ResponseEntity create(
            @RequestBody RouteDTO routeDTO
            ){
        return ResponseEntity.ok(routeService.create(routeDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(
            @PathVariable Long id
    )
    {
        try {
            return ResponseEntity.ok(routeService.getById(id));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    public ResponseEntity rename(
            @RequestBody RouteDTO routeDTO
    ){
        try {
            return ResponseEntity.ok(routeService.updateName(routeDTO));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping()
    public ResponseEntity deleteRoute(@RequestParam Long id){

        return ResponseEntity.ok(routeService.deleteById(id));
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(routeService.getAll());
    }

    @GetMapping("/fields")
    public ResponseEntity sendFields(){
        return ResponseEntity.ok(routeService.sendFields());
    }
}
