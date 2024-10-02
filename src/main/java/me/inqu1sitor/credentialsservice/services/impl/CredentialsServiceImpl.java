package me.inqu1sitor.credentialsservice.services.impl;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;
import me.inqu1sitor.credentialsservice.entities.CredentialsEntity;
import me.inqu1sitor.credentialsservice.exceptions.CodeAuthorisationException;
import me.inqu1sitor.credentialsservice.mappers.CredentialsMapper;
import me.inqu1sitor.credentialsservice.repositories.CacheRepository;
import me.inqu1sitor.credentialsservice.repositories.impl.CredentialsRepository;
import me.inqu1sitor.credentialsservice.services.CredentialsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CredentialsServiceImpl implements CredentialsService {

    private final CacheRepository<CredentialsRequestDto> cacheCredentialsRepository;
    private final CredentialsRepository credentialsRepository;
    private final CredentialsMapper credentialsMapper;
    private final CredentialsValidator credentialsValidator;

    @Override
    @Transactional
    public void startCredentialsRegistration(CredentialsRequestDto dto, String code, String cookieValue) {
        credentialsValidator.checkNoRepetitionsInDb(dto);
        cacheCredentialsRepository.save(formatKey(code, cookieValue), dto);
    }

    @Override
    @Transactional
    public void endCredentialsRegistration(String code, String cookieValue) {
        CredentialsRequestDto dto = cacheCredentialsRepository.get(formatKey(code, cookieValue)).orElseThrow(CodeAuthorisationException::new);
        credentialsValidator.checkNoRepetitionsInDb(dto);
        final CredentialsEntity entity = credentialsMapper.toEntity(dto);
        credentialsRepository.save(entity);
    }

    private static String formatKey(final String authCode, final String cookieValue) {
        return String.format("%s:%s", authCode, cookieValue);
    }
}
