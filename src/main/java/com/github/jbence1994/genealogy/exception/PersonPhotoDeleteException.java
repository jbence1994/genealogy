package com.github.jbence1994.genealogy.exception;

import java.util.UUID;

public class PersonPhotoDeleteException extends RuntimeException {
    public PersonPhotoDeleteException(UUID id) {
        super(String.format("Fénykép törlése az alábbi személynél: #%s sikertelen volt", id));
    }
}
