package com.example.taskmanager.EjemploOneToOne.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping
    public List<PersonDTO> getAll(){
        return personService.getAll();
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO person){
        return personService.create(person);
    }

    @GetMapping("/{uuid}")
    public PersonDTO getOne(@PathVariable String uuid){
        return personService.getOne(UUID.fromString(uuid));
    }

    @PutMapping
    public PersonDTO edit(@RequestBody PersonDTO personDTO){
        return personService.edit(personDTO);
    }
    @DeleteMapping("/{uuid}")
    public PersonDTO delete(@PathVariable String uuid){
        return personService.delete(UUID.fromString(uuid));
    }
}
