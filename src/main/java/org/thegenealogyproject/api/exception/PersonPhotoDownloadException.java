package org.thegenealogyproject.api.exception;

import java.util.UUID;

public class PersonPhotoDownloadException extends RuntimeException {
    public PersonPhotoDownloadException(UUID id) {
        super(String.format("Fénykép letöltése az alábbi személyhez: #%s sikertelen volt", id));
    }
}
