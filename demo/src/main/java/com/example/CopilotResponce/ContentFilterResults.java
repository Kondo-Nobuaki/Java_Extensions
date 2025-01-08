package com.example.CopilotResponce;

public class ContentFilterResults {
    private FilterResult hate;
    private FilterResult self_harm;
    private FilterResult sexual;
    private FilterResult violence;

    // Getters and setters
    public FilterResult getHate() {
        return hate;
    }

    public void setHate(FilterResult hate) {
        this.hate = hate;
    }

    public FilterResult getSelf_harm() {
        return self_harm;
    }

    public void setSelf_harm(FilterResult self_harm) {
        this.self_harm = self_harm;
    }

    public FilterResult getSexual() {
        return sexual;
    }

    public void setSexual(FilterResult sexual) {
        this.sexual = sexual;
    }

    public FilterResult getViolence() {
        return violence;
    }

    public void setViolence(FilterResult violence) {
        this.violence = violence;
    }
}
