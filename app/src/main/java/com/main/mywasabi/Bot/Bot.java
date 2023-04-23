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

    public ArrayList<String> getAnswersFromFile(String fileName) {
        ArrayList<String> answer = new ArrayList<String>();
        File file = new File(fileName);
        File file2 = new File("test.xsd");
        System.out.println("Absolute Path: " + file2.getAbsolutePath());
        System.out.println("Path: " + file2.getPath());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                System.out.println(st);
                answer.add(st);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return answer;
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
