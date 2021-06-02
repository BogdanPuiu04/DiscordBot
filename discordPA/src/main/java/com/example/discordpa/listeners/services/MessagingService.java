package com.example.discordpa.listeners.services;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;

import java.awt.*;
import java.util.Date;
import java.util.concurrent.CompletableFuture;


//Messaging service
public interface MessagingService {

    CompletableFuture<Void> sendFeed(String title, String articleAuthor, String description, Date date, String thumbnail, TextChannel textChannel, String link, Color color, boolean toDelete);

    void sendCommandsMessage(String title, String description, String thumbnail, String footer, TextChannel textChannel, Color color, boolean toDelete);
}
