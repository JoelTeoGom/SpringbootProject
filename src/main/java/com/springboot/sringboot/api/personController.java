package com.springboot.sringboot.api;

import com.springboot.sringboot.model.Person;
import com.springboot.sringboot.service.PersonService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person") // This is the path
@RestController
public class personController {
    private final PersonService personService;

    @Autowired // This is a constructor injection
    public personController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path="{id}") // This is the path
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path="{id}") // This is the path
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePersonById(id);
    }

    @PutMapping(path="{id}") // This is the path
    public void updatePersonById(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Person person) {
        personService.updatePersonById(id, person);
    }
}
