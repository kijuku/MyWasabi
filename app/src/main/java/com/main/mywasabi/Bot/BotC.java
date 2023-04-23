package com.main.mywasabi.Bot;

import static com.main.mywasabi.Bot.BotStyle.FUNNY;

public class BotC extends Bot{
    public BotC(String name) {
        super(name);
        config = new Config(name, FUNNY);
        answers = null;
        comments = null;

    }
}
