package edu.articles.terminal;

import edu.articles.dao.ArticleDao;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component("listArticles")
public class ListArticlesCommand implements TerminalCommand {
    @Resource
    private ArticleDao articleDao;

    @Override
    public void run() {
        articleDao.findAllArticles().forEach(System.out::println);
    }
}