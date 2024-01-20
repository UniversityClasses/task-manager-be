package com.example.taskmanager.EjemploOneToOne.Person;

import com.example.taskmanager.EjemploOneToOne.Passport.Passport;
import com.example.taskmanager.EjemploOneToOne.Passport.PassportDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public PersonDTO toDTO(Person person) {
        if (person == null){
            return  null;
        }
        return new PersonDTO(person.getUuid(),person.getName(),new PassportDTO("123456"));
    }

    public Person toModel(PersonDTO personDTO) {
        if (personDTO == null){
            return  null;
        }
        return new Person(personDTO.getName(),new Passport("123456"));
    }
}
