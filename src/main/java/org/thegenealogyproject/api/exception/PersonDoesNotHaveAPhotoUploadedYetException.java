package org.thegenealogyproject.api.exception;

import java.util.UUID;

public class PersonDoesNotHaveAPhotoUploadedYetException extends RuntimeException {
    public PersonDoesNotHaveAPhotoUploadedYetException(UUID id) {
        super(String.format("Személy a következő azonosítóval: #%s még nem rendelkezik feltöltött fényképpel", id));
    }
}
