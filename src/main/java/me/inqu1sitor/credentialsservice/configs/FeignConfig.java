package me.inqu1sitor.credentialsservice.configs;

import feign.Logger;
import me.inqu1sitor.credentialsservice.feign.MailServiceClient;
import me.inqu1sitor.credentialsservice.utils.ProjectProfiles;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(ProjectProfiles.REST)
@EnableFeignClients(
        basePackageClasses = {
                MailServiceClient.class
        }
)
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
