package com.example.backend.controller;

import com.example.backend.repository.WorkerRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/queries")
public class QueryController {
    private final WorkerRepo workerRepo;


    @GetMapping
    public ResponseEntity getAll(){
        Map<String, String> map = new HashMap<>();
        map.put("Получить данные об автопарке предприятия.", "/queries/1");
        map.put("Получить перечень и общее число водителей по предприятию, по указанной автомашине ", "/queries/2");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(map);
            return new ResponseEntity<>(jsonResult, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/1")
    public ResponseEntity getFirst(@RequestParam Long id){
        return ResponseEntity.ok(workerRepo.oleg(id));
    }

    @GetMapping("/1/params")
    public ResponseEntity sendFirstFields(){
        return new ResponseEntity(List.of("id"), HttpStatus.OK);
    }

    @GetMapping("/2")
    public ResponseEntity getSecond(){
        return ResponseEntity.ok(workerRepo.dima());
    }

    @GetMapping("/2/params")
    public ResponseEntity sendSecondFields(){
        return new ResponseEntity(List.of(), HttpStatus.OK);
    }

}
