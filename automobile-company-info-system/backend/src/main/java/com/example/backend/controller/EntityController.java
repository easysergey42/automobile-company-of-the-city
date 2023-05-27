package com.example.backend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/entities")
public class EntityController {

    @GetMapping
    public ResponseEntity getAll(){
        Map<String, String> map = new HashMap<>();
        map.put("Починки", "/repairs");
        map.put("Маршруты", "/routes");
        map.put("Автотранспорт", "/vehicles");
        map.put("Работники", "/workers");
        map.put("Автобусы", "/vehicles/buses");
        map.put("Маршрутки", "/vehicles/routeTaxis");
        map.put("Грузовики", "/vehicles/trucks");
        map.put("Грузоперевозки", "/vehicles/trucks/trucking");
        map.put("Такси", "/vehicles/taxis");
        map.put("Легковые автомобили", "/vehicles/passengerCars");
        map.put("Вспомогательный транспорт", "/vehicles/specialEquipmentCars");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(map);
            return new ResponseEntity<>(jsonResult, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
