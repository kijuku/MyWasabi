package com.main.mywasabi.Chat;

import java.util.Date;

public class Message {
    protected int id;
    protected String name;
    protected String message;
    protected Date timestamp;
    protected User user;

    public Message(int id) {

    }

    public Message (String name, String message ){
        this.name = name;
        this.message = message;
    }
    public Message(int id, String message) {
        this.id = id;
        this.message = message;
        this.timestamp = new Date();
    }

    public Message(int id, String message, Date timestamp) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
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
