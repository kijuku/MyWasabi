package com.main.mywasabi.Chat;

import com.main.mywasabi.Bot.Bot;
import com.main.mywasabi.Bot.BotA;
import com.main.mywasabi.Bot.BotB;
import com.main.mywasabi.Bot.BotC;
import com.main.mywasabi.Bot.BotD;
import com.main.mywasabi.Bot.BotE;

import java.util.ArrayList;
import java.util.Random;

public class Chat {
    protected ArrayList<Bot> bots = new ArrayList<>();
    protected ArrayList<User> users = new ArrayList<>();
    protected MessageList messageStorage = MessageList.getInstance();

    protected ArrayList<Message> messages = new ArrayList<>();

    protected ArrayList<Message> live = new ArrayList<>();
    private static Chat chatStorage = null;

    private Chat() {
        super();
    }

    /**
     * @return
     */
    public static Chat getInstance() {
        if (chatStorage == null) {
            chatStorage = new Chat();
        }
        return chatStorage;
    }

    public ArrayList<Bot> getBots() {
        return bots;
    }

    public ArrayList<Message> getLive() {
        return live;
    }

    public void setLive(ArrayList<Message> live) {
        this.live = live;
    }

    public void setBots(ArrayList<Bot> bots) {
        this.bots = bots;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public MessageList getMessageStorage() {
        return messageStorage;
    }

    public void setMessageStorage(MessageList messageStorage) {
        this.messageStorage = messageStorage;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public static Chat getChatStorage() {
        return chatStorage;
    }

    public static void setChatStorage(Chat chatStorage) {
        Chat.chatStorage = chatStorage;
    }

    public void addNewMessageToList(Message message){
        Chat.chatStorage.getMessages().add(message);
    }

    public void generateBotArmy(int count){
        if (count > 1) {
            Random rnd = new Random();
            int low = 0;
            int high = 5;
            int result = 0;
            Bot bot;
            String names[] = {"Elkku","Inkku <3 <3","Jarppi","Morkkis :(","Aatto","Lissu"};
            String backgroundColors[] = {"#ff7373","#01e2f6","#e9d9c0","#556d88","#ad95b9","#02febf"};
            for (int i = 0; i < count; i++) {
                result = rnd.nextInt(high-low) + low;
                String nameNow = names[i];
                String bgColor = backgroundColors[i];
                switch (result){
                    case 0:
                        bot = new BotA(nameNow,bgColor);
                        bot.setBotUser(new User(nameNow,nameNow+" Bot",bgColor));
                        users.add(bot.getBotUser());
                        break;
                    case 1:
                        bot = new BotB(nameNow,bgColor);
                        bot.setBotUser(new User(nameNow,nameNow+" Bot",bgColor));
                        users.add(bot.getBotUser());
                        break;
                    case 2:
                        bot = new BotC(nameNow,bgColor);
                        bot.setBotUser(new User(nameNow,nameNow+" Bot",bgColor));
                        users.add(bot.getBotUser());
                        break;
                    case 3:
                        bot = new BotD(nameNow,bgColor);
                        bot.setBotUser(new User(nameNow,nameNow+" Bot",bgColor));
                        users.add(bot.getBotUser());
                        break;
                    case 4:
                        bot = new BotE(nameNow,bgColor);
                        bot.setBotUser(new User(nameNow,nameNow+" Bot",bgColor));
                        users.add(bot.getBotUser());
                        break;
                    default:
                        bot = new BotA(nameNow,bgColor);
                        bot.setBotUser(new User(nameNow,nameNow+" Bot",bgColor));
                        users.add(bot.getBotUser());
                        break;
                }
                System.out.println("Lisättiin Botti: " + bot.getName());
                this.bots.add(bot);
            }
        }

    }

    @Override
    public String toString() {
        return "Chat{" +
                "bots=" + bots +
                ", users=" + users +
                ", messageStorage=" + messageStorage +
                '}';
    }
}
