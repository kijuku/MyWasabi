package com.main.mywasabi.Bot;

public class BotA extends Bot{


    public BotA(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name,BotStyle.ANGRY);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();

    }


}
