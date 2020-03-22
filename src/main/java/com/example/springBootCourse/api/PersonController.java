package com.example.springBootCourse.api;

import com.example.springBootCourse.model.Person;
import com.example.springBootCourse.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(Person person) {
        this.personService.addPerson(person);
    }
}
