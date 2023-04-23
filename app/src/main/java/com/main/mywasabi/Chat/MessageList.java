package com.main.mywasabi.Chat;

import java.util.ArrayList;
import java.util.Date;

public class MessageList {
    protected ArrayList<Message> messageList = new ArrayList<>();
    protected String name;
    private static MessageList messageStorage = null;

    private MessageList() {super();}
    public static MessageList getInstance() {
        if (messageStorage == null){
            messageStorage = new MessageList();
        }
        return messageStorage;
    }

    public ArrayList<Message> getMessages() {
        return messageList;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messageList = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMessage(Message message){
        this.messageList.add(message);
    }
    public void deleteMessage(int position){
        this.messageList.remove(position);
    }

    @Override
    public String toString() {
        return "MessageList{" +
                ", name='" + name + '\'' +
                "messageList=" + messageList +
                '}';
    }
}
