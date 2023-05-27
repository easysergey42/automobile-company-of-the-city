package com.example.backend.controller;

import com.example.backend.repository.VehicleRepo;
import com.example.backend.repository.WorkerRepo;
import com.example.backend.service.VehicleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/queries")
public class QueryController {
    private final WorkerRepo workerRepo;
    private final VehicleRepo vehicleRepo;
    private final VehicleService vehicleService;



    @GetMapping
    public ResponseEntity getAll(){
        Map<String, String> map = new HashMap<>();
//        map.put("");
        map.put("Получить данные о работах, выполненных обозначенной командой за обозначенный период", "/queries/15");
        map.put("Получить сведения о полученной и списанной автотехники за указанный период", "/queries/12");
        map.put("Получить данные о распределении автотранспорта на предприятии", "/queries/9");
        map.put("Получить данные о числе ремонтов и их стоимости для автотранспорта категории Легковые", "/queries/6");
        map.put("Получить данные о распределении пассажирского автотранспорта по маршрутам", "/queries/4");
        map.put("Получить распределение водителей по авто", "/queries/3");
        map.put("Получить общее число водителей по предприятию, по указанной автомашине ", "/queries/2");
        map.put("Получить данные об автопарке предприятия.", "/queries/1");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(map);
            return new ResponseEntity<>(jsonResult, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/15")
    public ResponseEntity get15(@RequestParam Date start,
                                @RequestParam Date end,
                                @RequestParam Long teamId){
        return ResponseEntity.ok(workerRepo.get15Query(start,end, teamId));
    }
    @GetMapping("/15/params")
    public ResponseEntity send15Fields(){
        return ResponseEntity.ok(List.of("start", "end", "teamId"));
    }
    @GetMapping("/12")
    public ResponseEntity get12(@RequestParam Date first,
                               @RequestParam Date second){
        return ResponseEntity.ok(workerRepo.get12Query(first,second));
    }
    @GetMapping("/12/params")
    public ResponseEntity send12Fields(){
        return ResponseEntity.ok(List.of("first", "second"));
    }
    @GetMapping("/9")
    public ResponseEntity get9(){
        return ResponseEntity.ok(workerRepo.get9Query());
    }
    @GetMapping("/9/params")
    public ResponseEntity send9Fields(){
        return ResponseEntity.ok(List.of());
    }
    @GetMapping("/6")
    public ResponseEntity getSixth(){
        return ResponseEntity.ok(workerRepo.getSixthQuery());
    }
    @GetMapping("/6/params")
    public ResponseEntity sendSixthFields(){
        return ResponseEntity.ok(List.of());
    }
    @GetMapping("/4")
    public ResponseEntity getFourth(){
        return ResponseEntity.ok(workerRepo.getFourthQuery());
    }
    @GetMapping("/4/params")
    public ResponseEntity sendFourthFields(){
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/1")
    public ResponseEntity getFirst(){
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/2")
    public ResponseEntity getSecond(@RequestParam Long vehicleId){
        return ResponseEntity.ok(workerRepo.getSecondQuery(vehicleId));
    }
    @GetMapping("/1/params")
    public ResponseEntity sendFirstFields(){
        return new ResponseEntity(List.of(), HttpStatus.OK);
    }
    @GetMapping("/2/params")
    public ResponseEntity sendSecondFields(){
        return new ResponseEntity(List.of("vehicleId"), HttpStatus.OK);
    }

    @GetMapping("/3/params")
    public ResponseEntity sendThirdFields(){
        return ResponseEntity.ok(List.of());
    }
    @GetMapping("/3")
    public ResponseEntity getThird(){
        return ResponseEntity.ok(workerRepo.getThirdQuery());
    }
}
