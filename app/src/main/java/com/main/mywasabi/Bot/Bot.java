package com.main.mywasabi.Bot;

import java.util.ArrayList;

public class Bot {
    protected String name;
    protected ArrayList<String>answers = new ArrayList<>();
    protected ArrayList<String>comments = new ArrayList<>();
    protected Config config;

    public Bot(String name, Config config) {
        this.name = name;
        this.config = config;
    }

    public Bot(String name, ArrayList<String> answers, ArrayList<String> comments, Config config) {
        this.name = name;
        this.answers = answers;
        this.comments = comments;
        this.config = config;
    }

    public Bot(Object o) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "name='" + name + '\'' +
                ", answers=" + answers +
                ", comments=" + comments +
                ", config=" + config +
                '}';
    }
}
