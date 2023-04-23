package com.main.mywasabi.Bot;

import static com.main.mywasabi.Bot.BotStyle.HUMOURLESS;

public class BotB extends Bot{
    public BotB(String name) {
        super(name);
        config = new Config(name, HUMOURLESS);
        answers = null;
        comments = null;

    }
}
