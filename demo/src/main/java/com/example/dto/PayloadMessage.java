package com.example.dto;
public class PayloadMessage {
    private String role;
    private String content;

    public PayloadMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }

    // Getters and setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
