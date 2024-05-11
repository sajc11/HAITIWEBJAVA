package com.example.haitiannewsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsResponse {
    @JsonProperty("articles")
    private NewsArticle[] articles;

    // Constructors
    public NewsResponse() {}

    // Getter and Setter
    public NewsArticle[] getArticles() {
        return articles;
    }

    public void setArticles(NewsArticle[] articles) {
        this.articles = articles;
    }
}
