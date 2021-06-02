package com.example.discordpa.listeners.implementation;

import com.example.discordpa.listeners.TopicListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;


@Component
public class TopicListenerImp implements TopicListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateListener) {

        if (messageCreateListener.getMessageContent().startsWith("!topics")) {
            messageCreateListener.getChannel().sendMessage("\uD83E\uDD16 My topics are:\nFor Java: `!feed java [number of articles]`\nFor Python: `!feed python [number of articles]`\nFor Programming: `!feed programming [number of articles]`\nFor C#: `!feed c# [number of articles]`\nFor Kotlin: `!feed kotlin [number of articles]`");
        }
    }
}
