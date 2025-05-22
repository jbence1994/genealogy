package com.github.jbence1994.genealogy.exception;

public class InvalidFileExtensionException extends RuntimeException {
    public InvalidFileExtensionException(String extension) {
        super(String.format("Hibás fájlformátum: %s", extension.toUpperCase()));
    }
}
