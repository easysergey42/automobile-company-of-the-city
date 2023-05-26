package com.example.backend.mappers;

import com.example.backend.dto.PersonDTO;
import com.example.backend.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {TeamMapper.class})
public interface PersonMapper {

    PersonDTO toDTO(Person person);

    Person toPerson(PersonDTO personDTO);
}
