package edu.articles.terminal;

import edu.articles.dao.ArticleDao;
import edu.articles.dto.Article;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Scanner;

@Component("addArticle")
public class AddArticleCommand implements TerminalCommand {
    @Resource
    private ArticleDao articleDao;

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter article title:");
        String title = s.nextLine();
        System.out.println("Enter article text:");
        String text = s.nextLine();
        System.out.println("Enter author ID:");
        String authorId = s.nextLine();

        Article article = new Article(title, text, new ObjectId(authorId));
        articleDao.saveArticle(article);
        System.out.println("Article saved!");
    }
}