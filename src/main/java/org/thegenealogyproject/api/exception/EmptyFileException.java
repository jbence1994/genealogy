package org.thegenealogyproject.api.exception;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException(String fileName) {
        super(String.format("Üres fájl: %s", fileName));
    }
}
