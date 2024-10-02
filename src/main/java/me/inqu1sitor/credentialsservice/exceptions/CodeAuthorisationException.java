package me.inqu1sitor.credentialsservice.exceptions;

public class CodeAuthorisationException extends RuntimeException {

    public CodeAuthorisationException() {
        this("Code is invalid or was expired");
    }

    public CodeAuthorisationException(String message) {
        super(message);
    }
}
