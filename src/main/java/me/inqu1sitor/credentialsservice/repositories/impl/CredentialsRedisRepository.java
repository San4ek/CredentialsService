package me.inqu1sitor.credentialsservice.repositories.impl;

import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
public class CredentialsRedisRepository extends RedisRepository<CredentialsRequestDto> {

    @Value("${authcode.ttl}")
    private int ttl;

    public CredentialsRedisRepository(RedisTemplate<String, Object> redisTemplate) {
        super(redisTemplate);
    }

    @Override
    public void save(String key, CredentialsRequestDto dto) {
        getRedisTemplate().opsForValue().set(key, dto, ttl, TimeUnit.SECONDS);
    }

    @Override
    @Transactional
    public Optional<CredentialsRequestDto> get(String key) {
        final Optional<CredentialsRequestDto> dto = Optional.ofNullable((CredentialsRequestDto) getRedisTemplate().opsForValue().get(key));
        remove(key);
        return dto;
    }
}
