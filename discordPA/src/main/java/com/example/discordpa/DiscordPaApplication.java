package com.example.discordpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class DiscordPaApplication {


    public static void main(String[] args) {
        SpringApplication.run(DiscordPaApplication.class, args);
    }

}
