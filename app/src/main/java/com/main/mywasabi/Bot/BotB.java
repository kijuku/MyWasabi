package com.main.mywasabi.Bot;

import static com.main.mywasabi.Bot.BotStyle.HUMOURLESS;

import com.main.mywasabi.Chat.User;

public class BotB extends Bot{
    public BotB(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name, HUMOURLESS);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();
    }
    public BotB(String name, String color) {
        super(name);
        this.name = name;
        this.config = new Config("BotStyle.HUMOURLESS", HUMOURLESS);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();
        this.botUser = new User(name,name+" Bot",color);
    }
}
