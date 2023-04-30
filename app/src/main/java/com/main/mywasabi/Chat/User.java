package com.main.mywasabi.Chat;

public class User {
    static int count = 0;
    protected String name;
    protected int id;
    protected String description;
    protected String backgroundColor;
    protected String favoriteComment;


    public User(String name) {
        this.name = name;
        this.id = count++;
        this.description = "";
        this.backgroundColor = "#2196F3";
        this.favoriteComment = ";)";
    }

    public User(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = count++;
        this.backgroundColor = "#2196F3";
        this.favoriteComment = ";)";
    }

    public User(String name, String description,String backgroundColor) {
        this.name = name;
        this.description = description;
        this.id = count++;
        this.backgroundColor = backgroundColor;
        this.favoriteComment = ";)";
    }

    public User(String name, String description, String backgroundColor, String favoriteComment) {
        this.name = name;
        this.id = count++;
        this.description = description;
        this.backgroundColor = backgroundColor;
        this.favoriteComment = favoriteComment;
    }

    public String getFavoriteComment() {
        return favoriteComment;
    }

    public void setFavoriteComment(String favoriteComment) {
        this.favoriteComment = favoriteComment;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        User.count = count;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
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
