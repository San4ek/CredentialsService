package me.inqu1sitor.credentialsservice.repositories;

import java.util.Optional;

public interface CacheRepository<T> {

    void save(String key, T t);

    Optional<T> get(String key);

    void remove(String key);
}
