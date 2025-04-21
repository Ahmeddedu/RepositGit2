package data.controller;

import data.dao.ArticleDao;
import data.dto.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ArticleController {

    @Resource
    private ArticleDao articleDao;

    @GetMapping("/articles")
    public String getAllArticles(Model model) {
        List<Article> articles = articleDao.findAllArticles();
        model.addAttribute("articles", articles);
        return "articles";
    }
}
