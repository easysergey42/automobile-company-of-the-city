package com.example.backend.service;

import com.example.backend.dto.WorkerDTO;
import com.example.backend.dto.front.WorkerFrontDTO;
import com.example.backend.entity.Person;
import com.example.backend.entity.Worker;
import com.example.backend.mappers.FrontMapper;
import com.example.backend.mappers.WorkerMapper;
import com.example.backend.repository.PersonRepo;
import com.example.backend.repository.TeamRepo;
import com.example.backend.repository.WorkerRepo;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerMapper workerMapper;
    private final WorkerRepo workerRepo;
    private final TeamRepo teamRepo;
    private final PersonRepo personRepo;
//    private final WorkerFrontMapper workerFrontMapper;

    private static Set<String> specs = Set.of("driver", "technician", "welder", "locksmith", "assembler");
    private static String validate(String spec){
        if (specs.contains(spec)) return spec;
        throw new IllegalArgumentException("Not a specialization");
    }

    @Transactional
    public WorkerDTO create(@NonNull WorkerFrontDTO request){
        Worker worker = new Worker();
        worker.setTeam(teamRepo.findById(request.getTeam()).get());
        Person person = new Person();
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        worker.setPerson(personRepo.save(person));
        worker.setSpec(validate(request.getSpec()));
        return workerMapper.toDTO(workerRepo.save(worker));
    }

    @Transactional
    public WorkerDTO update(@NonNull WorkerFrontDTO request){

        Worker worker = workerRepo.findById(request.getId()).get();
        worker.setTeam(teamRepo.findById(request.getTeam()).get());
        Person person = worker.getPerson();
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        worker.setPerson(personRepo.save(person));
        worker.setSpec(validate(request.getSpec()));
        return workerMapper.toDTO(workerRepo.save(worker));
    }

    @Transactional
    public Long deleteById(Long id){
        workerRepo.deleteById(id);
        return id;
    }


    @Transactional
    public List<WorkerFrontDTO> getAll(){
        List<Worker> workers = new ArrayList<>();
        workerRepo.findAll().forEach(workers::add);

        return workerMapper.toDTOs(workers).stream().map(FrontMapper::toWorkerFrontDTO).collect(Collectors.toList());
    }

    public List<String> sendFields(){
        return Arrays.stream(WorkerFrontDTO.class.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
    }

}
