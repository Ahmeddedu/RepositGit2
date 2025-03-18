package edu.articles;

import edu.articles.dao.ArticleDao;
import edu.articles.dao.UserDao;
import edu.articles.dto.Article;
import edu.articles.dto.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ArticlesStarter {

    public static void main(String... args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        //тут я раписал для себя на будущее
        // тут бин
        UserDao userDao = context.getBean(UserDao.class);

        // пользоватль
        User user = new User("Alice", 25);
        userDao.saveUser(user);

        //бин для этой статьи
        ArticleDao articleDao = context.getBean(ArticleDao.class);

        // сохраняем
        Article article = new Article("Перша стаття", "Це текст першої статті.");
        articleDao.saveArticle(article);

        // вывод статьи
        List<Article> articles = articleDao.findAllArticles();
        System.out.println("Всі статті:");
        for (Article a : articles) {
            System.out.println(a);
        }

        context.close();
    }
}