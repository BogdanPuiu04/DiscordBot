package com.example.discordpa.listeners.services.database;

import com.example.discordpa.listeners.QuestionListener;
import com.example.discordpa.questions.Question;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.sql.SQLException;


@Component
public class QuestionListenerImp implements QuestionListener {


    //Getting the questions
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith("!question")) {
            String keyword;
            String[] messages = messageCreateEvent.getMessageContent().split(" ");
            if (messages.length == 2) {
                keyword = messages[1];
                try {
                    Question question = FindByInfo.findQuestion(keyword);
                    if (!(question.getInfo() == null)) {
                        messageCreateEvent.getChannel().sendMessage("Info about `" + question.getKeyword() + "`: " + question.getInfo());
                    } else
                        messageCreateEvent.getChannel().sendMessage("❌ Unknown keyword `[" + messages[1] + "]`.Please use only the named keyword. To display all keywords use `!question` ❌");
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            } else {
                messageCreateEvent.getChannel().sendMessage("The command is `!question [keyword]`.Theese are the following keywords:\n");
                try {
                    messageCreateEvent.getChannel().sendMessage(FindByKeyWord.listAllKeywords());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
