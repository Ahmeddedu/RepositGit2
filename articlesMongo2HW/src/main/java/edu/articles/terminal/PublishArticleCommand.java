package edu.articles.terminal;

import edu.articles.dao.ArticleDao;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Scanner;

@Component("publishArticle")
public class PublishArticleCommand implements TerminalCommand {
    @Resource
    private ArticleDao articleDao;

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter article title to publish:");
        String title = s.nextLine();
        articleDao.publishArticle(title);
    }
}