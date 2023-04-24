package com.main.mywasabi.Bot;

import static com.main.mywasabi.Bot.BotStyle.FUNNY;

public class BotC extends Bot{
    public BotC(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name, FUNNY);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();
    }
}
