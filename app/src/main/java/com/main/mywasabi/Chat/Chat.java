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
    protected MessageList messageStorage = null;
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

    public void generateBotArmy(int count){
        if (count > 1) {
            Random rnd = new Random();
            int low = 0;
            int high = 5;
            int result = 0;
            Bot bot;
            String names[] = {"Elkku","Inkku <3 <3","Jarppi","Morkkis :(","Aatto","Lissu"};
            for (int i = 0; i < count; i++) {
                result = rnd.nextInt(high-low) + low;
                String nameNow = names[i];
                switch (result){
                    case 0:
                        bot = new BotA(nameNow);
                        break;
                    case 1:
                        bot = new BotB(nameNow);
                        break;
                    case 2:
                        bot = new BotC(nameNow);
                        break;
                    case 3:
                        bot = new BotD(nameNow);
                        break;
                    case 4:
                        bot = new BotE(nameNow);
                        break;
                    default:
                        bot = new BotA(nameNow);
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
