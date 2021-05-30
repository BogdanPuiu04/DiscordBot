package com.example.discordpa.listeners.implementation;

import com.example.discordpa.listeners.JavaFeedRequestListener;
import com.example.discordpa.listeners.services.MessagingService;
import com.sun.syndication.feed.synd.*;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.javacord.api.event.message.MessageCreateEvent;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;
import java.net.URL;


@Component
public class JavaFeedRequestListenerImp implements JavaFeedRequestListener {


    @Autowired
    private MessagingService messagingService;


    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
            if (messageCreateEvent.getMessageContent().startsWith("!feed")) {
                if(messageCreateEvent.getMessageContent().length()>5) {
                    String[] messages = messageCreateEvent.getMessageContent().split(" ");
                    if (messages.length > 2) {
                        String url;
                        url = GetUrlFetcher.getUrlForTopic(messages[1]);
                        int count = Integer.parseInt(messages[2]);
                        if (count <= 10 && url != null) {
                            try {
                                SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
                                feed.setFeedType("rss_2.0");

                                for (Object o : feed.getEntries()) {
                                    if (count == 0) {
                                        break;
                                    }
                                    int red = (int) Math.floor(Math.random() * 255);
                                    int green = (int) Math.floor(Math.random() * 255);
                                    int blue = (int) Math.floor(Math.random() * 255);
                                    SyndEntry entry = (SyndEntry) o;
                                    String article = Jsoup.parse(entry.getDescription().getValue()).text();
                                    String articleComplex = article.replace("To read this article in full, please click here", " ");
                                    messagingService.sendFeed(entry.getTitle(),
                                            "Author: " + entry.getAuthor(),
                                            articleComplex,
                                            entry.getPublishedDate(),
                                            feed.getImage().getUrl(),
                                            messageCreateEvent.getChannel(),
                                            entry.getLink(),
                                            new Color(red, green, blue)
                                    );
                                    count--;
                                }
                            } catch (FeedException | IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            if (count > 10) {
                                messageCreateEvent.getChannel().sendMessage("You can only get 10 articles.");
                            } else {
                                messageCreateEvent.getChannel().sendMessage("Invalid topic. Use `!topics` to display all topics.");
                            }
                        }
                    } else {
                        if (messages[1].equals("java")) {
                            messageCreateEvent.getChannel().sendMessage("You need to use `!feed [topic] [number of topics]` in order to a specific number of articles");
                        }


                    }
                }
            else  messageCreateEvent.getChannel().sendMessage("You need to use `!feed [topic] [number of topics]` in order to a specific number of articles");
            }
    }
}
