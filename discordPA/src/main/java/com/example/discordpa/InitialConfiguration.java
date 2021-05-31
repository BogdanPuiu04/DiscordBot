package com.example.discordpa;

import com.example.discordpa.listeners.*;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.management.Query;

@Configuration
public class InitialConfiguration {

    @Autowired
    private Environment env;
    @Autowired
    private JavaFeedRequestListener javaFeedRequestListener;
    @Autowired
    private TopicListener topicListener;
    @Autowired
    private QuestionListener questionListener;
    @Autowired
    private CommandsListener commandsListener;


    //Configuration
    @Bean
    @ConfigurationProperties(value = "discord-api")
    public DiscordApi discordApi() {
        String token = env.getProperty("TOKEN");
        DiscordApi api = new DiscordApiBuilder().setToken(token)
                .setAllNonPrivilegedIntents()
                .login()
                .join();
        //Adding the listeners
        api.updateActivity(ActivityType.LISTENING,"Spotify");
        api.addMessageCreateListener(javaFeedRequestListener);
        api.addMessageCreateListener(topicListener);
        api.addMessageCreateListener(questionListener);
        api.addMessageCreateListener(commandsListener);
        return api;
    }

}
