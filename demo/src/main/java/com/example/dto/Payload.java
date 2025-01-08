package com.example.dto;

import java.util.List;

public class Payload {
    private List<PayloadMessage> messages;

    // Getters and setters
    public List<PayloadMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<PayloadMessage> messages) {
        this.messages = messages;
    }
}
