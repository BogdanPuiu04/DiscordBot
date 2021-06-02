package com.example.discordpa.listeners.implementation;

import com.example.discordpa.listeners.CommandsListener;
import com.example.discordpa.listeners.services.MessagingService;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class CommandsServiceImp implements CommandsListener {

    @Autowired
    private MessagingService messagingService;


    //Lists nicely all the commands that the bot does
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith("!commands")) {
            int red = (int) Math.floor(Math.random() * 255);
            int green = (int) Math.floor(Math.random() * 255);
            int blue = (int) Math.floor(Math.random() * 255);
            messagingService.sendCommandsMessage("\uD83E\uDD16 My commands:",
                    "Theese are my commands: \n To get a news about a topic: `!feed [topic] [number of articles]`\nTo display the topics: `!topics`\n To ask me a question about `Java` use:`!question`",
                    "https://i.dlpng.com/static/png/6861076_preview.png",
                    "Use them as you please!\uD83D\uDE0A",
                    messageCreateEvent.getChannel(),
                    new Color(red, green, blue)
                    , true);
        }
    }
}
