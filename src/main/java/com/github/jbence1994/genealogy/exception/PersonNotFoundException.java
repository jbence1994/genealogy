package com.github.jbence1994.genealogy.exception;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(UUID id) {
        super(String.format("Személy a következő azonosítóval: #%s nem található", id));
    }
}
