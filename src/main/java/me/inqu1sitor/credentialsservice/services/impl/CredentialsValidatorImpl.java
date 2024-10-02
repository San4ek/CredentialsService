package me.inqu1sitor.credentialsservice.services.impl;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;
import me.inqu1sitor.credentialsservice.repositories.impl.CredentialsRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class CredentialsValidatorImpl implements CredentialsValidator {

    private final CredentialsRepository credentialsRepository;

    @Override
    @Transactional(readOnly = true)
    public void checkNoRepetitionsInDb(CredentialsRequestDto dto) {
        Assert.isTrue(!credentialsRepository.existsByEmail(dto.email()), "Credentials already registered");
    }
}
