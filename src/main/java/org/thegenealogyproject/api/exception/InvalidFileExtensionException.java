package org.thegenealogyproject.api.exception;

public class InvalidFileExtensionException extends RuntimeException {
    public InvalidFileExtensionException(String extension) {
        super(String.format("Hibás fájlformátum: %s", extension.toUpperCase()));
    }
}
