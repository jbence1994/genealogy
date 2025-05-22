package com.github.jbence1994.genealogy.exception;

import java.util.UUID;

public class PersonPhotoNotFoundException extends RuntimeException {
    public PersonPhotoNotFoundException(UUID id) {
        super(String.format("Személy a következő azonosítóval: #%s nem rendelkezik feltöltött fényképpel", id));
    }
}
