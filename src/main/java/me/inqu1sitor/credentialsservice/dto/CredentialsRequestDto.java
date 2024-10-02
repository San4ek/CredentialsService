package me.inqu1sitor.credentialsservice.dto;

import java.io.Serializable;

public record CredentialsRequestDto(
        String email,
        String password
) implements Serializable {

    @Override
    public String toString() {
        return "CredentialsRequestDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
