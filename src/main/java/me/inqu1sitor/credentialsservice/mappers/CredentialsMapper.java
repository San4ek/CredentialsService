package me.inqu1sitor.credentialsservice.mappers;

import me.inqu1sitor.credentialsservice.dto.CredentialsRequestDto;
import me.inqu1sitor.credentialsservice.entities.CredentialsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CredentialsMapper {

    CredentialsEntity toEntity(final CredentialsRequestDto credentialsRequestDto);
}
