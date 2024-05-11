package com.example.haitiannewsapp.controller;

import com.example.haitiannewsapp.NewsService;
import com.example.haitiannewsapp.model.NewsArticle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String showNews(Model model) {
        // Fetch the Haitian news using the NewsService
        List<NewsArticle> news = newsService.fetchHaitianNews();
        // Add the fetched news to the model to make it available in the Thymeleaf view
        model.addAttribute("news", news);
        return "index";  // Points to src/main/resources/templates/index.html
    }
}
