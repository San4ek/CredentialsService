package me.inqu1sitor.credentialsservice.controllers;

import me.inqu1sitor.credentialsservice.dto.AuthCodeRequestDto;
import me.inqu1sitor.credentialsservice.dto.CodeResponseDto;
import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;
import me.inqu1sitor.credentialsservice.exceptions.NotImplementedException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;

@RequestMapping(
        value = "${path.controllers.credentials}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public interface CredentialsController {

    @PostMapping
    default ResponseEntity<CodeResponseDto> registerAccount(@RequestBody final CredentialsRequestDto dto) throws NoSuchAlgorithmException {
        throw NotImplementedException.defaultInstance();
    }

    @PutMapping("${path.endpoints.auth-code}")
    default ResponseEntity<?> authoriseCode(@RequestBody final AuthCodeRequestDto dto, @CookieValue(value = "CODECOOKIE", required = false) final String cookieValue) {
        throw NotImplementedException.defaultInstance();
    }

    @PutMapping
    default void updateCredentials(@RequestBody final CredentialsRequestDto dto) {
        throw NotImplementedException.defaultInstance();
    }

    @DeleteMapping
    default void deleteCredentials() {
        throw NotImplementedException.defaultInstance();
    }
}
