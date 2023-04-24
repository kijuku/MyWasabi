package com.main.mywasabi.Bot;

public class BotE extends Bot{
    public BotE(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name,BotStyle.JOKING);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();

    }
}
