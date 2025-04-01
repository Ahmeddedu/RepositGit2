package data.terminal;

import data.dao.ArticleDao;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component("listArticles")
public class ListArticlesCommand implements TerminalCommand {
    @Resource
    private ArticleDao articleDao;

    @Override
    public void run() {
        articleDao.findAllArticles().forEach(System.out::println);
    }
}