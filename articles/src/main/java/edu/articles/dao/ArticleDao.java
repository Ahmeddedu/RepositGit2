package edu.articles.dao;

import edu.articles.dto.Article;

import java.util.List;

public interface ArticleDao {
    void saveArticle(Article article);  // сохранить типо
    List<Article> findAllArticles();
}