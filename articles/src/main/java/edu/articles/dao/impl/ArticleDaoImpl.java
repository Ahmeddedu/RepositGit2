package edu.articles.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.articles.dao.ArticleDao;
import edu.articles.dto.Article;
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
                .append("text", article.getText());
        articleCollection.insertOne(doc);
    }

    @Override
    public List<Article> findAllArticles() {
        List<Article> articles = new ArrayList<>();
        for (Document doc : articleCollection.find()) {
            articles.add(new Article(doc.getString("title"), doc.getString("text")));
        }
        return articles;
    }
}