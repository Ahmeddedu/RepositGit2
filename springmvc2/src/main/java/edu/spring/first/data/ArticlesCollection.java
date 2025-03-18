package edu.spring.first.data;

import java.util.List;

public class ArticlesCollection {
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    private  List<Article> articles;

}
