package me.inqu1sitor.credentialsservice.notificators;

import lombok.RequiredArgsConstructor;
import me.inqu1sitor.credentialsservice.dto.WithEmailRequestDto;
import me.inqu1sitor.credentialsservice.exceptions.InternalServerError;
import me.inqu1sitor.credentialsservice.utils.ProjectProfiles;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Profile(ProjectProfiles.RABBIT)
public class RabbitEmailNotificator implements EmailNotificator {

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;

    @Value("${rabbit.rpc.routing-key}")
    private String routingKey;

    @Override
    public void rpcNotification(WithEmailRequestDto dto) {
        Optional<Boolean> isSuccess = Optional.ofNullable((Boolean) rabbitTemplate.convertSendAndReceive(directExchange.getName(), routingKey, dto));
        if (isSuccess.isEmpty()) {
            throw new InternalServerError("RabbitMQ Notification Failed");
        }
        if (Boolean.FALSE.equals(isSuccess.get())) {
            throw new UnableToSendNotificationException(String.format("Email %s incorrect or not exists", dto.receiverEmail()));
        }
    }
}
