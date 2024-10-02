package me.inqu1sitor.credentialsservice.controllers.impl;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.controllers.CredentialsController;
import me.inqu1sitor.credentialsservice.dto.AuthCodeRequestDto;
import me.inqu1sitor.credentialsservice.dto.CodeResponseDto;
import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;
import me.inqu1sitor.credentialsservice.services.CredentialsControllerProcessor;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CredentialsControllerImpl implements CredentialsController {

    private final CredentialsControllerProcessor credentialsControllerProcessor;

    @Override
    public ResponseEntity<CodeResponseDto> registerAccount(CredentialsRequestDto dto) {
        final HttpCookie cookie = credentialsControllerProcessor.processCodeReceiving(dto);
        return ResponseEntity.
                ok().
                header(HttpHeaders.SET_COOKIE, cookie.toString()).
                body(CodeResponseDto.success(dto.email()));
    }

    @Override
    public ResponseEntity<?> authoriseCode(AuthCodeRequestDto dto, String cookieValue) {
        final HttpCookie cookie = credentialsControllerProcessor.processCodeAuthorisation(dto, cookieValue);
        return ResponseEntity.ok().
                header(HttpHeaders.SET_COOKIE, cookie.toString()).
                build();
    }
}
