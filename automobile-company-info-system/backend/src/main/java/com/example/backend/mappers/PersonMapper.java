package com.example.backend.mappers;

import com.example.backend.dto.PersonDTO;
import com.example.backend.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDTO(Person person);

    Person toPerson(PersonDTO personDTO);
}
