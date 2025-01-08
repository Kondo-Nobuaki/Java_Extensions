package com.example.CopilotResponce;

public class PromptFilterResult {
    private ContentFilterResults content_filter_results;
    private int prompt_index;

    // Getters and setters
    public ContentFilterResults getContent_filter_results() {
        return content_filter_results;
    }

    public void setContent_filter_results(ContentFilterResults content_filter_results) {
        this.content_filter_results = content_filter_results;
    }

    public int getPrompt_index() {
        return prompt_index;
    }

    public void setPrompt_index(int prompt_index) {
        this.prompt_index = prompt_index;
    }
}
