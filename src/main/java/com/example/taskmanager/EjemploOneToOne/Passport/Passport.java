package com.example.taskmanager.EjemploOneToOne.Passport;

import com.example.taskmanager.EjemploOneToOne.Person.Person;
import com.example.taskmanager.Generics.ModelBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Passport extends ModelBase {

    private String number;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    public Passport(String name,String number, Person person) {
        super.setName(name);
        this.number = number;
        this.person = person;
    }

    public Passport(){}

    public Passport(String number){
        this.number = number;
    }

    @PrePersist
    public void initializeUuid() {
        this.setUuid(UUID.randomUUID());
    }
}