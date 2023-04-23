package com.main.mywasabi.Bot;

public class BotE extends Bot{
    public BotE(String name) {
        super(name);
        config = new Config(name,BotStyle.JOKING);
        answers = null;
        comments = null;

    }
}
