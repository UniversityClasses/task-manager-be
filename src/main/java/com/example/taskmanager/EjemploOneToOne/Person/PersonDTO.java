package com.example.taskmanager.EjemploOneToOne.Person;

import com.example.taskmanager.EjemploOneToOne.Passport.Passport;
import com.example.taskmanager.EjemploOneToOne.Passport.PassportDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Data
@Component
public class PersonDTO {
    private UUID uuid;

    @NotBlank(message="Name cannot be blank")
    @Size(max = 200, min = 3)
    private String name;
    private PassportDTO passport;

    public PersonDTO(UUID uuid, String name, PassportDTO passport) {
        this.uuid = uuid;
        this.name = name;
        this.passport = passport;
    }

    public PersonDTO(UUID uuid){
        this.uuid = uuid;
    }
    public PersonDTO(){}
}
