package me.inqu1sitor.credentialsservice.services;

import me.inqu1sitor.credentialsservice.dto.AuthCodeRequestDto;
import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;
import org.springframework.http.HttpCookie;

public interface CredentialsControllerProcessor {

    HttpCookie processCodeReceiving(final CredentialsRequestDto dto);

    HttpCookie processCodeAuthorisation(final AuthCodeRequestDto dto, final String cookieValue);
}
