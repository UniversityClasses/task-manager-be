package com.example.taskmanager.EjemploOneToOne.Person;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PersonService {
    List<PersonDTO> getAll();

    PersonDTO create(PersonDTO person);

    PersonDTO getOne(UUID uuid);

    PersonDTO edit(PersonDTO personDTO);

    PersonDTO delete(UUID uuid);
}
