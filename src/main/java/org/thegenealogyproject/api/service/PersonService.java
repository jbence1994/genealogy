package org.thegenealogyproject.api.service;

import org.thegenealogyproject.api.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> getPeople();

    Person getPerson(UUID id);

    void updatePerson(Person person);
}
