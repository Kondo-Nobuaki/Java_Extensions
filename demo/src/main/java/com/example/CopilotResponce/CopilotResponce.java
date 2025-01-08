package com.example.CopilotResponce;

import java.util.List;

public class CopilotResponce {
    private List<Choice> choices;
    private long created;
    private String id;
    private String model;
    private List<PromptFilterResult> prompt_filter_results;
    private Usage usage;

    // Getters and setters
    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<PromptFilterResult> getPrompt_filter_results() {
        return prompt_filter_results;
    }

    public void setPrompt_filter_results(List<PromptFilterResult> prompt_filter_results) {
        this.prompt_filter_results = prompt_filter_results;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
