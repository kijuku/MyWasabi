package com.main.mywasabi.Bot;

public class Config {
    protected String name;
    protected BotStyle style;

    public Config(String name, BotStyle style) {
        this.name = name;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BotStyle getStyle() {
        return style;
    }

    public void setStyle(BotStyle style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Config{" +
                "name='" + name + '\'' +
                ", style=" + style +
                '}';
    }
}
