package com.main.mywasabi.Chat;

public class User {
    static int count = 0;
    protected String name;
    protected int id;
    protected String description;

    public User(String name) {
        this.name = name;
        this.id = count++;
        this.description = "";
    }

    public User(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
