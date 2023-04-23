package com.main.mywasabi.Bot;

public class BotD extends Bot{
    public BotD(String name) {
        super(name);
        config = new Config(name,BotStyle.SAD);
        answers = null;
        comments = null;

    }
}
