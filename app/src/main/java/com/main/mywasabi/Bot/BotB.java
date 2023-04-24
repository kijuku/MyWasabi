package com.main.mywasabi.Bot;

import static com.main.mywasabi.Bot.BotStyle.HUMOURLESS;

public class BotB extends Bot{
    public BotB(String name) {
        super(name);
        this.name = name;
        this.config = new Config(name, HUMOURLESS);
        this.answers = new Answer().getAns();
        this.comments = new Comment().getAi();
    }
}
