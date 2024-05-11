package com.example.haitiannewsapp.controller;

import com.example.haitiannewsapp.service.NewsService;
import com.example.haitiannewsapp.model.NewsArticle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String index() {
        return "index"; // Returns the landing page template
    }
    @GetMapping("/essay")
    public String essay() {
        return "essay"; // Returns the landing page template
    }
    @GetMapping("/news")
    public String showNews(Model model) {
        // Fetch the Haitian news using the NewsService
        List<NewsArticle> news = newsService.fetchHaitianNews();
        // Add the fetched news to the model to make it available in the Thymeleaf view
        model.addAttribute("news", news);
        return "news";  // Points to src/main/resources/templates/news.html
    }
}
