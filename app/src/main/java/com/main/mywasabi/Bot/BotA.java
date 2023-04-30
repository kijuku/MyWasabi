package com.main.mywasabi.Bot;

import com.main.mywasabi.Chat.User;

public class BotA extends Bot{


    public BotA(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name,BotStyle.ANGRY);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();

    }
    public BotA(String name,String color) {
        super(name);
        this.name = name;
        this.config = new Config("BotStyle.ANGRY",BotStyle.ANGRY);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();
        this.botUser = new User(name,name+" Bot",color);
    }

}
