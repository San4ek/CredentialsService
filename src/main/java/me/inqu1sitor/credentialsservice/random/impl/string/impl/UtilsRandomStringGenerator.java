package me.inqu1sitor.credentialsservice.random.impl.string.impl;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.random.impl.string.RandomStringGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UtilsRandomStringGenerator implements RandomStringGenerator {

    @Override
    public String generate() {
        return RandomStringUtils.randomAlphanumeric(16);
    }
}
