package data.dao;

import data.dto.Article;
import java.util.List;

public interface ArticleDao {
    void saveArticle(Article article);
    List<Article> findAllArticles();
    List<Article> findArticlesByTitle(String title);
    List<Article> findPublishedArticlesByTitle(String title);
    void publishArticle(String title);
}