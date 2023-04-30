package com.main.mywasabi.Bot;

import com.main.mywasabi.Chat.User;

public class BotE extends Bot{
    public BotE(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name,BotStyle.JOKING);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();

    }

    public BotE(String name,String color) {
        super(name);
        this.name = name;
        this.config = new Config("BotStyle.JOKING",BotStyle.JOKING);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();
        this.botUser = new User(name,name+" Bot",color);

    }
}
