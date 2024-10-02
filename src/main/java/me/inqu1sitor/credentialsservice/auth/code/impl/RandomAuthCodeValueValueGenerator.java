package me.inqu1sitor.credentialsservice.auth.code.impl;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.auth.code.AuthCodeValueGenerator;
import me.inqu1sitor.credentialsservice.random.impl.integer.RandomIntGenerator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RandomAuthCodeValueValueGenerator implements AuthCodeValueGenerator {

    private final RandomIntGenerator randomIntGenerator;

    @Override
    public String generate() {
        return String.valueOf(randomIntGenerator.between(1000, 9999));
    }
}
