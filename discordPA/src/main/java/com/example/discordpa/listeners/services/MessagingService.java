package com.example.discordpa.listeners.services;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;

import java.awt.*;
import java.util.Date;
import java.util.concurrent.CompletableFuture;


//Messaging service
public interface MessagingService {
    CompletableFuture<Message> sendMessage(MessageAuthor author, String title, String description, String footer, String thumbnail, TextChannel textChannel, Color color);

    void sendMessage(MessageAuthor author, String title, String description, String footer, String thumbnail, TextChannel textChannel, Color color, boolean toDelete);

    CompletableFuture<Message> sendFeed(String title, String articleAuthor, String description, Date date, String thumbnail, TextChannel textChannel, String link, Color color);

    void sendCommandsMessage(String title, String desciption, String thumbnail, String footer, TextChannel textChannel, Color color, boolean toDelete);
}
