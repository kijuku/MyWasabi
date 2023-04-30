package com.main.mywasabi.Bot;

import com.main.mywasabi.Chat.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Bot {
    protected String name;
    protected ArrayList<String>answers = new ArrayList<>();
    protected ArrayList<String>comments = new ArrayList<>();
    protected Config config;
    protected User botUser;

    public Bot(String name, Config config) {
        this.name = name;
        this.config = config;
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.botUser = new User(name,name+" Bot");
    }

    public Bot(String name, ArrayList<String> answers, ArrayList<String> comments, Config config) {
        this.name = name;
        this.answers = answers;
        this.comments = comments;
        this.config = config;
        this.botUser = new User(name,name+" Bot");
    }
    public Bot(String name, Config config, String backgroundColor) {
        this.name = name;
        this.config = config;
        this.botUser = new User(name,name+" Bot",backgroundColor);
    }

    public Bot(Object o) {
    }

    public User getBotUser() {
        return botUser;
    }

    public void setBotUser(User botUser) {
        this.botUser = botUser;
    }

    public String getComment(int position){
        int testPos = position;
        if (this.getComments()== null) return "<3 <3 :)";
        if (testPos > this.getComments().size()) testPos = this.getComments().size();

        return this.getComments().get(testPos);
    }

    public String randomComment(){
        Random rnd = new Random();
        int low = 0;
        if (this.getComments()== null) return "<3<3 xD xD";
        int high = getComments().size();
        if (high > getComments().size())  high = getComments().size();

        int pos = rnd.nextInt(high-low) + low;

        return this.getComments().get(pos);
    }

    public String randomAnswer(){
        Random rnd = new Random();
        int low = 0;

        if (this.getAnswers()== null) return ":(";

        int high = getAnswers().size();

        if (high > getAnswers().size())  high = getAnswers().size();

        int pos = rnd.nextInt(high-low) + low;

        return this.getAnswers().get(pos);
    }

    public String getAnswer(int position){
        int testPos = position;
        if (this.getAnswers()== null) return ":(";
        if (testPos > this.getAnswers().size()) testPos = this.getAnswers().size();

        return this.getAnswers().get(testPos);
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
