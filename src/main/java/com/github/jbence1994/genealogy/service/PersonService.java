package com.github.jbence1994.genealogy.service;

import com.github.jbence1994.genealogy.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> getPeople();

    Person getPerson(UUID id);

    void updatePerson(Person person);
}
