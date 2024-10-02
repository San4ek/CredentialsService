package me.inqu1sitor.credentialsservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record CredentialsRequestDto(
        @Email(message = "Email format is required")
        @NotNull(message = "Email is required")
        String email,
        @NotNull(message = "Password is required")
        @Size(min = 6, max =16, message = "Password length should be between 6 and 16 characters")
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
