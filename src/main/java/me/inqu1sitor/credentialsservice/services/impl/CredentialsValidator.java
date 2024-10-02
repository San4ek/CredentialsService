package me.inqu1sitor.credentialsservice.services.impl;

import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;

public interface CredentialsValidator {

    void checkNoRepetitionsInDb(final CredentialsRequestDto dto);
}
