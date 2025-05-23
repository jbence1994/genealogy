package org.thegenealogyproject.api.exception;

import java.util.UUID;

public class PersonAlreadyHasAPhotoUploadedException extends RuntimeException {
    public PersonAlreadyHasAPhotoUploadedException(UUID id) {
        super(String.format("Személy a következő azonosítóval: #%s már rendelkezik feltöltött fényképpel", id));
    }
}
