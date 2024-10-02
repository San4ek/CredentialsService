package me.inqu1sitor.credentialsservice.feign;

import me.inqu1sitor.credentialsservice.configs.FeignConfig;
import me.inqu1sitor.credentialsservice.dto.WithEmailRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "mailservice",
        url = "${remote-services.mail-service.url}" + "/api/email",
        configuration = FeignConfig.class
)
public interface MailServiceClient {

    @PostMapping
    void sendEmail(@RequestBody WithEmailRequestDto dto);
}
