package edu.articles.terminal;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import edu.articles.dto.Article;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component("findByAuthor")
public class FindArticlesByAuthorCommand implements TerminalCommand {
    @Resource
    private MongoDatabase database;
    private MongoCollection<Document> articleCollection;

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter author ID:");
        String authorId = s.nextLine();

        articleCollection = database.getCollection("articles");
        List<Article> articles = new ArrayList<>();
        for (Document doc : articleCollection.find(Filters.eq("authorId", new ObjectId(authorId)))) {
            articles.add(new Article(
                    doc.getString("title"),
                    doc.getString("text"),
                    doc.getObjectId("authorId")
            ));
        }
        articles.forEach(System.out::println);
    }
}