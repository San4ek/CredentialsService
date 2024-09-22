package me.inqu1sitor.credentialsservice.dto;

public record RegCredentialsRequestDto(
        String name,
        String email,
        String password
) {
}
