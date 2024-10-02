package me.inqu1sitor.credentialsservice.random.impl.integer.impl;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.random.impl.integer.RandomIntGenerator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class JdkRandomIntGenerator implements RandomIntGenerator {

    private static final Random random = new Random();

    @Override
    public Integer between(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    @Override
    public Integer generate() {
        return random.nextInt();
    }
}
