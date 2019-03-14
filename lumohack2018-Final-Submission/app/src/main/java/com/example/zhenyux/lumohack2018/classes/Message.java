package com.example.zhenyux.lumohack2018.classes;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private List<String> messageList;
    private List<Integer> messageType;
    private int messageNumber;

    private static Message instance;

    private Message(){}

    public static Message getInstance(){
        if (instance == null){
            instance = new Message();
            instance.initialize();
        }
        return instance;
    }

    public void initialize() {
        this.messageList = new ArrayList<String>();
        this.messageType = new ArrayList<Integer>();
        this.setMessageNumber(-1);
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(String message) {
        messageList.add(message);
    }

    public int getMessageType(int position) {
        return messageType.get(position);
    }

    public void setMessageType(int type) {
        messageType.add(type);
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public int getMessageNumber() {
        return messageNumber;
    }
}
