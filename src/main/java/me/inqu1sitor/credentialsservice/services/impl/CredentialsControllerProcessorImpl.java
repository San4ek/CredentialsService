package me.inqu1sitor.credentialsservice.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.inqu1sitor.credentialsservice.auth.code.AuthCodeValueGenerator;
import me.inqu1sitor.credentialsservice.auth.cookie.CodeCookieGenerator;
import me.inqu1sitor.credentialsservice.auth.cookie.CookieValueGenerator;
import me.inqu1sitor.credentialsservice.dto.AuthCodeRequestDto;
import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;
import me.inqu1sitor.credentialsservice.dto.WithEmailRequestDto;
import me.inqu1sitor.credentialsservice.notificators.EmailNotificator;
import me.inqu1sitor.credentialsservice.services.CredentialsControllerProcessor;
import me.inqu1sitor.credentialsservice.services.CredentialsService;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CredentialsControllerProcessorImpl implements CredentialsControllerProcessor {

    private final CredentialsService credentialsService;
    private final CookieValueGenerator cookieValueGenerator;
    private final CodeCookieGenerator codeCookieGenerator;
    private final AuthCodeValueGenerator authCodeValueGenerator;
    private final EmailNotificator emailNotificator;

    @Override
    @Transactional
    public HttpCookie processCodeReceiving(CredentialsRequestDto dto) {
        final String cookieValue = cookieValueGenerator.generate();
        final String authCode = authCodeValueGenerator.generate();
        credentialsService.startCredentialsRegistration(dto, authCode, cookieValue);
        emailNotificator.rpcNotification(WithEmailRequestDto.codeMessage(dto.email(), authCode));
        return codeCookieGenerator.generate(cookieValue);
    }

    @Override
    public HttpCookie processCodeAuthorisation(AuthCodeRequestDto authCodeDto, String cookieValue) {
        credentialsService.endCredentialsRegistration(authCodeDto.code(), cookieValue);
        return ((ResponseCookie) codeCookieGenerator.generate(null)).mutate().maxAge(0).build();
    }
}
