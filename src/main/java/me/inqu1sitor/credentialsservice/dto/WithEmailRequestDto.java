package me.inqu1sitor.credentialsservice.dto;

public record WithEmailRequestDto(
        String receiverEmail,
        String mailTheme,
        String mailMessage
) {

    public static WithEmailRequestDto codeMessage(final String email, final String code) {
        return new WithEmailRequestDto(email, "Authorisation code", code);
    }
}