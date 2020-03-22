package com.example.springBootCourse.service;

import com.example.springBootCourse.dao.PersonDao;
import com.example.springBootCourse.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return this.personDao.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return this.personDao.selectAllPersons();
    }

    public Optional<Person> getPersonById(UUID id) {
        return this.personDao.selectPersonById(id);
    }

    public int deletePersonById(UUID id) {
        return this.personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person personToUpdate) {
        return this.personDao.updatePersonById(id, personToUpdate);
    }
}
