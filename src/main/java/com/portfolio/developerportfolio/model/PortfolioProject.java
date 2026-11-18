package com.portfolio.developerportfolio.model;

import java.util.List;

public class PortfolioProject {

    private final String number;
    private final String category;
    private final String title;
    private final String description;
    private final List<String> technologies;
    private final String githubUrl;
    private final String liveUrl;

    public PortfolioProject(String number, String category, String title, String description,
                            List<String> technologies, String githubUrl, String liveUrl) {
        this.number = number;
        this.category = category;
        this.title = title;
        this.description = description;
        this.technologies = List.copyOf(technologies);
        this.githubUrl = githubUrl;
        this.liveUrl = liveUrl;
    }

    public String getNumber() {
        return number;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public String getLiveUrl() {
        return liveUrl;
    }
}
