package com.example.springBootCourse.service;

import com.example.springBootCourse.dao.PersonDao;
import com.example.springBootCourse.model.Person;

public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return this.personDao.insertPerson(person);
    }
}
