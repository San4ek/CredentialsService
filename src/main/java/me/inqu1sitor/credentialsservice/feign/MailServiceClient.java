package me.inqu1sitor.credentialsservice.feign;

import me.inqu1sitor.credentialsservice.configs.FeignConfig;
import me.inqu1sitor.credentialsservice.dto.WithEmailRequestDto;
import me.inqu1sitor.credentialsservice.utils.ProjectProfiles;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Profile(ProjectProfiles.REST)
@FeignClient(
        value = "mailservice",
        url = "${remote-services.mail-service.url}" + "/api/email",
        configuration = FeignConfig.class
)
public interface MailServiceClient {

    @PostMapping
    void sendEmail(@RequestBody WithEmailRequestDto dto);
}
