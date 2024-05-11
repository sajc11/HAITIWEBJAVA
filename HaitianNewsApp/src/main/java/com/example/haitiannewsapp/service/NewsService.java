package com.example.haitiannewsapp;

import com.example.haitiannewsapp.model.NewsArticle;
import com.example.haitiannewsapp.model.NewsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import com.example.haitiannewsapp.model.NewsResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class NewsService {
    private final String API_KEY = "fa7c75b119e44c3995a046f861c24142";
    private final String NEWS_API_URL = "https://newsapi.org/v2/top-headlines?country=ht&apiKey=" + API_KEY;

    public List<NewsArticle> fetchHaitianNews() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            NewsResponse response = restTemplate.getForObject(NEWS_API_URL, NewsResponse.class);
            if (response != null && response.getArticles() != null) {
                return Arrays.asList(response.getArticles());
            }
        } catch (HttpClientErrorException e) {
            System.err.println("Error fetching news: " + e.getStatusCode());
        }
        return Arrays.asList(); // Return an empty list if there's an error
    }
}
