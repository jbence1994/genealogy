package org.thegenealogyproject.api.exception;

import java.util.UUID;

public class PersonPhotoUploadException extends RuntimeException {
    public PersonPhotoUploadException(UUID id) {
        super(String.format("Fénykép feltöltése az alábbi személyhez: #%s sikertelen volt", id));
    }
}
