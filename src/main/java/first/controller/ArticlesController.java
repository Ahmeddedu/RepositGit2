package first.controller;

import first.data.Article;
import first.data.ArticleStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ArticlesController {

    @Autowired
    ArticleStore dataSource;

    @GetMapping("/articles")
    public String list(Model model) {
        model.addAttribute("articles", dataSource.getArticles());
        return "/allArticles";
    }

    @PostMapping("/articles")
    public RedirectView add(@RequestParam(name = "title") String title,
                            @RequestParam(name = "text") String text) {
        dataSource.addArticle(new Article(title, text));
         return new RedirectView("/articles");
    }

    /*
    @GetMapping("/foos/{id}")
    @ResponseBody
    public String getFooById(@PathVariable String id) {
        return "ID: " + id;
    }

     */
}
