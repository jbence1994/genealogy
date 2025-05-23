package org.thegenealogyproject.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thegenealogyproject.api.model.Person;
import org.thegenealogyproject.api.service.PersonService;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @QueryMapping(name = "person")
    public Person person(@Argument UUID id) {
        return personService.getPerson(id);
    }
}
