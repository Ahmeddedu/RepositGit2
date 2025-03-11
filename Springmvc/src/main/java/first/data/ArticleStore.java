package first.data;

import java.util.List;

public interface ArticleStore {
    List<Article> getArticles();

    void addArticle(Article a);

    void removeArticle(Article a);
}
