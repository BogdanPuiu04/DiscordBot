# DiscordBot

Technologies used in this project :  Spring  ,Discord API (Javacord)  
ROME (for RSS)  
-JSoup ( to parse XML articles)  
-Hibernate  
-MySQL(to stock the answers about some Java)
  
 HOW TO USE IT: 
  !commands  -- the bot will display all the commands in a message type MessageBuilder you can use
  !topics    -- the bot will display all the topics for a feed
  !feed [topic] [number of articles]  -- the bot will retrieve a specific number of articles (starting from the newest) with : The title, The Author, a short description and a link
  !question  -- the bot will display all the keywords you can use to ask him a question.
  !question [keyword]  -- the bot will answer to your question with a short information.
  
  HOW IT WORKS: 
    The discord api has specific listeners that will analyze your command and pass it on to process it. For the feed command , a SyndFeed will be created ( syndication from ROME),
 and will read the XML file retrived from the specific URL. After that a MessageBuilder will be created to return the info towards the channel that was created.
    The user will notified if he introduces a command that does not match a known value/keyword and it will be display the right command format.
    For the question command , the bot will retrive the entry for that specific keyword and it will send the information in a message at the same channel you requested.
  
