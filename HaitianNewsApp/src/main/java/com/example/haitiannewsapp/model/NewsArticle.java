package com.example.haitiannewsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsArticle {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("url") // Ensure this matches the JSON property name for the URL
    private String url;

    // Constructors
    public NewsArticle() {}

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() { // Getter for the URL
        return url;
    }

    public void setUrl(String url) { // Setter for the URL
        this.url = url;
    }
}
