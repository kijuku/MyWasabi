package com.main.mywasabi.Bot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public String getComment(int position){
        return this.getComments().get(position);
    }
    public String getAnswer(int position){
        return this.getAnswers().get(position);
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
