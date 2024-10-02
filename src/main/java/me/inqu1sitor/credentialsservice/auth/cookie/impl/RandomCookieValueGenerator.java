package me.inqu1sitor.credentialsservice.auth.cookie.impl;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.auth.cookie.CookieValueGenerator;
import me.inqu1sitor.credentialsservice.random.impl.string.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RandomCookieValueGenerator implements CookieValueGenerator {

    private final RandomStringGenerator randomStringGenerator;

    @Override
    public String generate() {
        return randomStringGenerator.generate();
    }
}
