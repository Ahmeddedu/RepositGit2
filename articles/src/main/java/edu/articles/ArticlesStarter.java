package edu.articles;

import com.mongodb.client.*;
import edu.articles.dao.UserDao;
import edu.articles.dao.impl.UserDaoImpl;
import edu.articles.dto.User;
import org.bson.Document;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArticlesStarter {

    public static void main(String... args){
        MongoClient mongoClient =  MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document>  userCol =  db.getCollection("users");
        Document doc1 = new Document("name", "Olga").append("age", 12);
        userCol.insertOne(doc1);
        List<User> users = new ArrayList<>();
        FindIterable<Document> foundDocuments = userCol.find();
        for (Document doc : foundDocuments) {
            User u = new User(doc.getObjectId("_id"), doc.getString("name"), doc.getInteger("age"));
            users.add(u);
        }
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println();
    }

    public static void main1(String... args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserDao userDao = context.getBean(UserDao.class);

        // Save a user
        User user = new User("Alice", 25);
        userDao.saveUser(user);


        userDao.saveUser(new User("Bohdan", 11));
        userDao.saveUser(new User("Taras", 15));

        System.out.println("User saved!");

        // Fetch all users
        System.out.println("Users in DB: " + userDao.findAllUsers());

        // Cleanup
        context.close();
    }
}
