package me.inqu1sitor.credentialsservice.notificators;

import me.inqu1sitor.credentialsservice.dto.WithEmailRequestDto;

public interface EmailNotificator {

    void rpcNotification(final WithEmailRequestDto dto);
}
