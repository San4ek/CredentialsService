package me.inqu1sitor.credentialsservice.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public record AuthCodeRequestDto(
        @NotNull(message = "Code is required")
        @Digits(integer = 4, fraction = 0, message = "Code should consists of 4 digits")
        String code
) {
}
