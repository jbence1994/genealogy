package com.github.jbence1994.genealogy.service;

import com.github.jbence1994.genealogy.exception.PersonNotFoundException;
import com.github.jbence1994.genealogy.model.Person;
import com.github.jbence1994.genealogy.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(UUID id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }
}
