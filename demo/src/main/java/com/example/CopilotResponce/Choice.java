package com.example.CopilotResponce;

public class Choice {
    private ContentFilterResults content_filter_results;
    private String finish_reason;
    private int index;
    private Message message;

    // Getters and setters
    public ContentFilterResults getContent_filter_results() {
        return content_filter_results;
    }

    public void setContent_filter_results(ContentFilterResults content_filter_results) {
        this.content_filter_results = content_filter_results;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}