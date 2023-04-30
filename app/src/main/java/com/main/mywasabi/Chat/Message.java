package com.main.mywasabi.Chat;

import android.graphics.Color;

import java.util.Date;

public class Message {
    protected int id;
    protected String name;
    protected String message;
    protected Date timestamp;
    protected User user;

    protected int backgroundColor;

    public Message(int id) {

    }

    public Message (String name, String message ){
        this.name = name;
        this.message = message;
        this.timestamp = new Date();
        this.user = new User(name);
        this.backgroundColor = Color.parseColor("#CDDC39");
    }
    public Message(int id, String message) {
        this.id = id;
        this.message = message;
        this.timestamp = new Date();
        this.user = new User("Me: ");
        this.backgroundColor = Color.parseColor("#CDDC39");
    }

    public Message(int id, String message, Date timestamp) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
        this.user = new User("Me: ");
        this.backgroundColor = Color.parseColor("#CDDC39");
    }
    public Message(int id, String message, User user) {
        this.id = id;
        this.message = message;
        this.timestamp = new Date();
        this.user = user;
        this.backgroundColor = Color.parseColor("#CDDC39");
    }
    public Message(int id, String message, User user, String colorStr) {
        this.id = id;
        this.message = message;
        this.timestamp = new Date();
        this.user = user;
        this.backgroundColor = Color.parseColor(colorStr);
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
