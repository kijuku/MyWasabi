package com.main.mywasabi.Bot;

import static com.main.mywasabi.Bot.BotStyle.FUNNY;

import com.main.mywasabi.Chat.User;

public class BotC extends Bot{
    public BotC(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name, FUNNY);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();
    }
    public BotC(String name,String color) {
        super(name);
        this.name = name;
        this.config = new Config("BotStyle.FUNNY", FUNNY);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();
        this.botUser = new User(name,name+" Bot",color);
    }
}
