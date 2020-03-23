package com.example.springBootCourse.api;

import com.example.springBootCourse.model.Person;
import com.example.springBootCourse.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody @Valid @NonNull Person person) {
        this.personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return this.personService.getAllPersons();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return this.personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        this.personService.deletePersonById(id);
    }

    @PatchMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id,
                                 @Valid @NonNull @RequestBody Person personToUpdate) {
        this.personService.updatePersonById(id, personToUpdate);
    }
}
