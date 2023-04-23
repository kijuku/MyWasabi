package com.main.mywasabi.Bot;

public class BotA extends Bot{


    public BotA(String name) {
        super(name);
        config = new Config(name,BotStyle.ANGRY);
        answers = null;
        comments = null;

    }
}
