package controller;

import data.dao.ArticleDao;
import data.dto.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticlesController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping("/articles")
    public String showArticles(Model model) {
        model.addAttribute("articles", articleDao.findAllArticles());
        return "articles";
    }
}