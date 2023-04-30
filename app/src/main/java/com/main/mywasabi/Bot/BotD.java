package com.main.mywasabi.Bot;

import static com.main.mywasabi.Bot.BotStyle.FUNNY;

import com.main.mywasabi.Chat.User;

public class BotD extends Bot{
    public BotD(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name,BotStyle.SAD);
        this.answers = null;
        this.comments = null;

    }
    public BotD(String name,String color) {
        super(name);
        this.name = name;
        this.config = new Config("BotStyle.SAD",BotStyle.SAD);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();
        this.botUser = new User(name,name+" Bot",color);

    }
}
