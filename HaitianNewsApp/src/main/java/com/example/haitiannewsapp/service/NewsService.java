package com.example.haitiannewsapp.service;

import com.example.haitiannewsapp.model.NewsArticle;
import com.example.haitiannewsapp.model.NewsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Arrays;
import java.util.List;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NewsService {
    private final String API_KEY = "fa7c75b119e44c3995a046f861c24142";

    public List<NewsArticle> fetchHaitianNews() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String query = "(Haiti OR Haitian) AND (democracy OR voting OR legislation OR youth action OR youth education OR civic education OR sgbv)";
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
            String NEWS_API_URL = "https://newsapi.org/v2/everything?q=" + encodedQuery + "&sortBy=publishedAt&language=en&apiKey=" + API_KEY;

            NewsResponse response = restTemplate.getForObject(NEWS_API_URL, NewsResponse.class);
            if (response != null && response.getArticles() != null) {
                Set<String> titles = new HashSet<>();
                return Arrays.stream(response.getArticles())
                        .filter(article -> article.getTitle() != null && !article.getTitle().isEmpty())
                        .filter(article -> !"[Removed]".equals(article.getTitle()))
                        .filter(article -> !article.getTitle().matches("Links\\s\\d+/\\d+/\\d{4}:.*")) // Excluding links like "Links 5/9/2024: ..."
                        .filter(article -> containsKeywords(article.getTitle().toLowerCase(), "haiti", "haitian"))
                        .filter(article -> article.getDescription() != null && containsKeywords(article.getDescription().toLowerCase(), "haiti", "haitian"))
                        .filter(article -> titles.add(article.getTitle())) // This line ensures uniqueness based on title
                        .collect(Collectors.toList());
            }
        } catch (HttpClientErrorException e) {
            System.err.println("Error fetching news: " + e.getStatusCode() + ", " + e.getResponseBodyAsString());
        } catch (Exception e) {
            System.err.println("General error: " + e.getMessage());
            e.printStackTrace();
        }
        return Arrays.asList(); // Return an empty list if there's an error
    }
    private double countKeywordDensity(String text, String keyword) {
        int count = 0;
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            if (word.equals(keyword)) {
                count++;
            }
        }
        return count / (double) words.length;
    }
    // Helper method to check if the text contains any of the keywords
    private boolean containsKeywords(String text, String... keywords) {
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

}
