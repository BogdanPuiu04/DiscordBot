package com.example.discordpa.listeners.implementation;

import com.example.discordpa.listeners.DeleteMessageOnReactionListener;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.springframework.stereotype.Component;


@Component
public class DeleteMessageOnReactionListenerImp implements DeleteMessageOnReactionListener {


    //Delete on reaction with thumbs down
    @Override
    public void onReactionAdd(ReactionAddEvent reactionAddEvent) {
        if (reactionAddEvent.getEmoji().equalsEmoji("\uD83D\uDC4E")) {
            reactionAddEvent.deleteMessage();
        }
        if (reactionAddEvent.getEmoji().equalsEmoji("\uD83D\uDC4D")) {
            reactionAddEvent.addReactionsToMessage("\uD83D\uDC4D");
        }

    }
}
