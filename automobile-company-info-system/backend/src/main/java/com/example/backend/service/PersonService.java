package com.example.backend.service;

import com.example.backend.dto.PersonDTO;
import com.example.backend.mappers.PersonMapper;
import com.example.backend.repository.PersonRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonMapper personMapper;
    private final PersonRepo personRepo;

    public PersonDTO create(@NonNull PersonDTO personDTO){
        return personMapper.toDTO(personRepo.save(personMapper.toPerson(personDTO)));
    }
}
