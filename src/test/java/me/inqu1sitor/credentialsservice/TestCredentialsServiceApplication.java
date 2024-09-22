package me.inqu1sitor.credentialsservice;

import org.springframework.boot.SpringApplication;

public class TestCredentialsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(CredentialsServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
