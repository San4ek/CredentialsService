package me.inqu1sitor.credentialsservice.controllers;

import me.inqu1sitor.credentialsservice.dto.AuthoriseCodeRequestDto;
import me.inqu1sitor.credentialsservice.dto.ChgCredentialsRequestDto;
import me.inqu1sitor.credentialsservice.dto.RegCredentialsRequestDto;
import me.inqu1sitor.credentialsservice.exceptions.NotImplementedException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(
        value = "/api/credentials",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public interface CredentialsController {

    @PostMapping
    default ResponseEntity<?> registerAccount(@RequestBody final RegCredentialsRequestDto dto) {
        throw NotImplementedException.defaultInstance();
    }

    @PutMapping("/code")
    default void authoriseCode(@RequestBody final AuthoriseCodeRequestDto dto) {
        throw NotImplementedException.defaultInstance();
    }

    @PutMapping
    default void updateCredentials(@RequestBody final ChgCredentialsRequestDto dto) {
        throw NotImplementedException.defaultInstance();
    }

    @DeleteMapping
    default void deleteCredentials() {
        throw NotImplementedException.defaultInstance();
    }
}
