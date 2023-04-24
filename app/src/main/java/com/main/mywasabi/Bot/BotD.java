package com.main.mywasabi.Bot;

public class BotD extends Bot{
    public BotD(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name,BotStyle.SAD);
        this.answers = null;
        this.comments = null;

    }
}
