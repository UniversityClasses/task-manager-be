package com.example.taskmanager.EjemploOneToOne.Passport;

import com.example.taskmanager.EjemploOneToOne.Person.PersonDTO;
import lombok.Data;

@Data
public class PassportDTO {
    private String number;

    private PersonDTO person;

    public PassportDTO(String number, PersonDTO person) {
        this.number = number;
        this.person = person;
    }

    public PassportDTO(String number){
        this.number = number;
    }
}
