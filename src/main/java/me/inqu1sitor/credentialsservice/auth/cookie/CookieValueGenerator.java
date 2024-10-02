package me.inqu1sitor.credentialsservice.auth.cookie;

import me.inqu1sitor.credentialsservice.random.RandomObjectGenerator;

@FunctionalInterface
public interface CookieValueGenerator extends RandomObjectGenerator<String> {

}
