package com.github.jbence1994.genealogy.exception;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException(String fileName) {
        super(String.format("Üres fájl: %s", fileName));
    }
}
