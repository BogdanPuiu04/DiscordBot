package com.example.discordpa.listeners.services.impl;

import com.example.discordpa.listeners.DeleteMessageOnReactionListener;
import com.example.discordpa.listeners.services.MessagingService;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


@Component
public class MessagingServiceImpl implements MessagingService {
    @Autowired
    private DeleteMessageOnReactionListener deleteMessageOnReactionListener;

    @Override
    public CompletableFuture<Void> sendFeed(String title, String articleAuthor, String description, Date date, String thumbnail, TextChannel textChannel, String link, Color color, boolean toDelete) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = "Date: " + dateFormat.format(date);
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setTitle(title)
                .setUrl(link)
                .setAuthor(articleAuthor)
                .setDescription(description)
                .setFooter(strDate)
                .setColor(color)
                .setThumbnail(thumbnail))
                .send(textChannel).thenAccept(message -> message.addReactionAddListener(deleteMessageOnReactionListener)
                        .removeAfter(30, TimeUnit.SECONDS));
    }

    @Override
    public void sendCommandsMessage(String title, String description, String thumbnail, String footer, TextChannel textChannel, Color color, boolean toDelete) {
        MessageBuilder messageBuilder = new MessageBuilder().setEmbed(new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setFooter(footer)
                .setThumbnail(thumbnail)
                .setColor(color));
        messageBuilder.send(textChannel)
                .thenAccept(message -> message.addReactionAddListener(deleteMessageOnReactionListener)
                        .removeAfter(30, TimeUnit.SECONDS));
    }
}
