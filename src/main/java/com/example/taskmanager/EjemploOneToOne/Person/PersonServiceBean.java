package com.example.taskmanager.EjemploOneToOne.Person;

import com.example.taskmanager.EjemploOneToOne.Passport.Passport;
import com.example.taskmanager.EjemploOneToOne.Passport.PassportDTO;
import com.example.taskmanager.EjemploOneToOne.Passport.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonServiceBean implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private PassportRepository passportRepository;
    @Override
    public List<PersonDTO> getAll() {
        return personRepository.findAll()
                .stream()
                .map(person -> mapper.toDTO(person))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO create(PersonDTO person) {
        Person createPerson  = mapper.toModel(person);
        PassportDTO passport = person.getPassport();
        if (passport != null){
            Optional<Passport> passpt = passportRepository.findPassportByUuid(person.getUuid());
            if(!passpt.isEmpty()){
                createPerson.setPassport(passpt.get());
            }
        }

        Person created = personRepository.save(createPerson);
        return mapper.toDTO(created);
    }

    @Override
    public PersonDTO getOne(UUID uuid) {
        Person person = new Person(uuid);
        Optional<Person> personSearched = personRepository.findOne(Example.of(person));
        if(!personSearched.isEmpty()){
            person = personSearched.get();
        }
        return mapper.toDTO(person);
    }

    @Override
    public PersonDTO edit(PersonDTO personDTO) {
        return null;
    }

    @Override
    public PersonDTO delete(UUID uuid) {
        Person person = new Person(uuid);
        Optional<Person> personSearched = personRepository.findOne(Example.of(person));
        Person backup = null;
        if(!personSearched.isEmpty()){
            person = personSearched.get();
            backup = person;
            personRepository.delete(person);

        }
        return mapper.toDTO(backup);
    }
}
