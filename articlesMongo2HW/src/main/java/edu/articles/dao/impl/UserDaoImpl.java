package edu.articles.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import edu.articles.dao.UserDao;
import edu.articles.dto.User;
import org.bson.Document;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Resource
    private MongoDatabase database;

    private MongoCollection<Document> userCollection;

    @PostConstruct
    public void init() {
        this.userCollection = database.getCollection("users");
    }

    @Override
    public void saveUser(User user) {
        Document doc = new Document("name", user.getName())
                .append("age", user.getAge());
        userCollection.insertOne(doc);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        for (Document doc : userCollection.find()) {
            Object k = doc.get("_id");
            users.add(new User(doc.getObjectId("_id"), doc.getString("name"), doc.getInteger("age")));
        }
        return users;
    }

    @Override
    public User findByName(String name) {
        Document doc = userCollection.find(Filters.eq("name", name)).first();
        return (doc != null) ? new User(doc.getObjectId("_id"), doc.getString("name"), doc.getInteger("age")) : null;
    }
}