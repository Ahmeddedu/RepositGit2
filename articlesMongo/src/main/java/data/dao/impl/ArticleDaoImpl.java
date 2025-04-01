package data.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import data.dao.ArticleDao;
import data.dto.Article;
import org.bson.Document;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleDaoImpl implements ArticleDao {

    @Resource
    private MongoDatabase database;

    private MongoCollection<Document> articleCollection;

    @PostConstruct
    public void init() {
        this.articleCollection = database.getCollection("articles");
    }

    @Override
    public void saveArticle(Article article) {
        Document doc = new Document("title", article.getTitle())
                .append("text", article.getText())
                .append("isPublished", article.isPublished())
                .append("authorId", article.getAuthorId());
        articleCollection.insertOne(doc);
    }

    @Override
    public List<Article> findAllArticles() {
        List<Article> articles = new ArrayList<>();
        for (Document doc : articleCollection.find()) {
            articles.add(new Article(
                    doc.getString("title"),
                    doc.getString("text"),
                    doc.getObjectId("authorId")
            ));
        }
        return articles;
    }

    @Override
    public List<Article> findArticlesByTitle(String title) {
        List<Article> articles = new ArrayList<>();
        for (Document doc : articleCollection.find(Filters.eq("title", title))) {
            articles.add(new Article(
                    doc.getString("title"),
                    doc.getString("text"),
                    doc.getObjectId("authorId")
            ));
        }
        return articles;
    }

    @Override
    public List<Article> findPublishedArticlesByTitle(String title) {
        List<Article> articles = new ArrayList<>();
        for (Document doc : articleCollection.find(Filters.and(
                Filters.eq("title", title),
                Filters.eq("isPublished", true)
        ))) {
            articles.add(new Article(
                    doc.getString("title"),
                    doc.getString("text"),
                    doc.getObjectId("authorId")
            ));
        }
        return articles;
    }

    @Override
    public void publishArticle(String title) {
        articleCollection.updateOne(
                Filters.eq("title", title),
                Updates.set("isPublished", true)
        );
        System.out.println("Стаття з заголовком '" + title + "' опублікована.");
    }
}