package com.example.CopilotResponce;

public class FilterResult {
    private boolean filtered;
    private String severity;

    // Getters and setters
    public boolean isFiltered() {
        return filtered;
    }

    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
