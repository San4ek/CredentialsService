package me.inqu1sitor.credentialsservice.services;

import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;

public interface CredentialsService {

    void startCredentialsRegistration(final CredentialsRequestDto dto, final String code, final String cookieValue);

    void endCredentialsRegistration(String code, String cookieValue);
}
