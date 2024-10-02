package me.inqu1sitor.credentialsservice.exceptions;

public class InternalServerError extends RuntimeException {

    public InternalServerError() {
        this("Internal server error");
    }

    public InternalServerError(String message) {
        super(message);
    }
}
