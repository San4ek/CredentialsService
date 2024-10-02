package me.inqu1sitor.credentialsservice.repositories.impl;

import me.inqu1sitor.credentialsservice.entities.CredentialsEntity;
import me.inqu1sitor.credentialsservice.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CredentialsRepository extends BaseRepository<CredentialsEntity, UUID> {

    boolean existsByEmail(final String email);
}
