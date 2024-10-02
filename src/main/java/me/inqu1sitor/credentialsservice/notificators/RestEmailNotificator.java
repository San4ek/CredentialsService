package me.inqu1sitor.credentialsservice.notificators;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.dto.WithEmailRequestDto;
import me.inqu1sitor.credentialsservice.feign.MailServiceClient;
import me.inqu1sitor.credentialsservice.utils.ProjectProfiles;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile(ProjectProfiles.REST)
public class RestEmailNotificator implements EmailNotificator {

    private final MailServiceClient mailServiceClient;

    @Override
    public void rpcNotification(WithEmailRequestDto dto) {
        mailServiceClient.sendEmail(dto);
    }
}
