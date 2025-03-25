package edu.articles;

import edu.articles.dao.ArticleDao;
import edu.articles.dto.Article;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ArticlesStarter {

    public static void main(String... args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ArticleDao articleDao = context.getBean(ArticleDao.class);

        Article article = new Article("Перша стаття", "Це текст першої статті.");
        articleDao.saveArticle(article);

        List<Article> articlesByTitle = articleDao.findArticlesByTitle("Перша стаття");
        System.out.println("Статті з заголовком 'Перша стаття':");
        for (Article a : articlesByTitle) {
            System.out.println(a);
        }

        articleDao.publishArticle("Перша стаття");

        List<Article> publishedArticles = articleDao.findPublishedArticlesByTitle("Перша стаття");
        System.out.println("Опубліковані статті з заголовком 'Перша стаття':");
        for (Article a : publishedArticles) {
            System.out.println(a);
        }

        context.close();
    }
}