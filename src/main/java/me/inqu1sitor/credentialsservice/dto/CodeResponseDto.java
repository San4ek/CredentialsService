package me.inqu1sitor.credentialsservice.dto;

public record CodeResponseDto(
        String message
) {

    public static CodeResponseDto of(final String message) {
        return new CodeResponseDto(message);
    }

    public static CodeResponseDto success(final String mail) {
        return of("Authorisation code was sent to " + mail);
    }
}
