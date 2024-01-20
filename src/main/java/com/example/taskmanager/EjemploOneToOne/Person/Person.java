package com.example.taskmanager.EjemploOneToOne.Person;

import com.example.taskmanager.EjemploOneToOne.Passport.Passport;
import com.example.taskmanager.Generics.ModelBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Person extends ModelBase {

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Passport passport;

    public Person(String name, Passport passport) {
        super.setName(name);
        this.passport = passport;
    }
    public  Person(){}
    public  Person(UUID uuid){
        super.setUuid(uuid);
    }
    @PrePersist
    public void initializeUuid() {
        this.setUuid(UUID.randomUUID());
    }
}

