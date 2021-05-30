package com.example.discordpa;

import com.example.discordpa.listeners.JavaFeedRequestListener;
import com.example.discordpa.listeners.RateListener;
import com.example.discordpa.listeners.TopicListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class InitialConfiguration {

    @Autowired
    private Environment env;

    @Autowired
    private RateListener rateListener;
    @Autowired
    private JavaFeedRequestListener javaFeedRequestListener;
    @Autowired
    private TopicListener topicListener;

    @Bean
    @ConfigurationProperties(value = "discord-api")
    public DiscordApi discordApi() {
        String token = env.getProperty("TOKEN");
        DiscordApi api = new DiscordApiBuilder().setToken(token)
                .setAllNonPrivilegedIntents()
                .login()
                .join();
        api.addMessageCreateListener(rateListener);
        api.addMessageCreateListener(javaFeedRequestListener);
        api.addMessageCreateListener(topicListener);
        return api;
    }
}
