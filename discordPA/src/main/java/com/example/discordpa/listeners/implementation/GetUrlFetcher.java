package com.example.discordpa.listeners.implementation;

public class GetUrlFetcher {

    public static String getUrlForTopic(String topic){
        if(topic.equals("java"))
        {
            return "https://www.infoworld.com/category/java/index.rss";
        }
        else {
            if(topic.equals("programming")) {
               return  "https://www.thecrazyprogrammer.com/feed";
            }
            if(topic.equals("python"))
            {
              return "https://blog.finxter.com/feed";
            }
            if(topic.equals("c#")){
                return "https://devblogs.microsoft.com/dotnet/feed/";
            }
            if(topic.equals("kotlin")){
                return "https://blog.karumi.com/rss/";
            }
        }
        return null;
    }
}
