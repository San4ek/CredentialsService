package me.inqu1sitor.credentialsservice.random.impl.integer;

import me.inqu1sitor.credentialsservice.random.RandomObjectGenerator;

public interface RandomIntGenerator extends RandomObjectGenerator<Integer> {

    Integer between(int min, int max);
}
