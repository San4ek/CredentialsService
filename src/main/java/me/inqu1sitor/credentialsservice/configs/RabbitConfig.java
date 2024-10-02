package me.inqu1sitor.credentialsservice.configs;

import me.inqu1sitor.credentialsservice.utils.ProjectProfiles;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(ProjectProfiles.RABBIT)
public class RabbitConfig {

    @Bean
    public DirectExchange exchange(@Value("${rabbit.rpc.direct-exchanger.name}") final String exchangerName) {
        return new DirectExchange(exchangerName);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
