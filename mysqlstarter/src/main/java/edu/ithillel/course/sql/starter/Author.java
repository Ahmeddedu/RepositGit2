package edu.ithillel.course.sql.starter;

import java.util.List;
import java.util.ArrayList;

public class Author {
    private int id;
    private String name;
    private List<Article> articles = new ArrayList<>();

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", articles=" + articles +
                '}';
    }
}