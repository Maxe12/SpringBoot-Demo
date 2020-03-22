package com.example.springBootCourse.api;

import com.example.springBootCourse.model.Person;
import com.example.springBootCourse.service.PersonService;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person) {
        this.personService.addPerson(person);
    }
}
