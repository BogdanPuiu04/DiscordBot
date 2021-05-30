package com.example.discordpa.listeners.implementation;

import com.example.discordpa.listeners.DeleteMessageOnReactionListener;
import com.example.discordpa.listeners.RateListener;
import com.example.discordpa.listeners.services.MessagingService;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class RateListenerImp implements RateListener {


    @Autowired
    private DeleteMessageOnReactionListener deleteMessageOnReactionListener;
    @Autowired
    private MessagingService messagingService;
    private final static Pattern pattern = Pattern.compile("!rate (\\w+)");

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith("!rate")) {
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());


            if (matcher.matches()) {
                int rating = (int) Math.floor(Math.random() * 100) + 1;
                messagingService.sendMessage(messageCreateEvent.getMessageAuthor(), "Rate calculator:",
                        messageCreateEvent.getMessageAuthor().getDisplayName() + " is " + rating + "% " + matcher.group(1),
                        "Rate again?",
                        "https://e7.pngegg.com/pngimages/785/145/png-clipart-java-development-kit-software-development-kit-computer-programming-computer-icons-programming-language-icon-text-logo-thumbnail.png",
                        messageCreateEvent.getChannel(),
                        true);
            } else {
                messagingService.sendMessage(
                        messageCreateEvent.getMessageAuthor(),
                        "Rate calculator",
                        "You used the `!rate` command incorrect.Please use `!rate [word] syntax.`",
                        "Rate again?",
                        null,
                        messageCreateEvent.getChannel()
                );
            }
        }
    }

}
