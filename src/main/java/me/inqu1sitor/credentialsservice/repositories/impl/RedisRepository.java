package me.inqu1sitor.credentialsservice.repositories.impl;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.repositories.CacheRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@RequiredArgsConstructor
public abstract class RedisRepository<T> implements CacheRepository<T> {

    private final RedisTemplate<String, Object> redisTemplate;

    protected RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    @Override
    public void remove(String key) {
        getRedisTemplate().delete(key);
    }
}
