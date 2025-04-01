package data;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MongoSamples {

    public static void main(String... args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = mongoClient.getDatabase("FunnyZoo");

        MongoCollection<Document> parrots = database.getCollection("parrots");
        zooSave(parrots);
        findAndParseAndOut(parrots);
        favoriteWords(database);

        findByFavoriteWord(database, "Hello!");

        updateParrotSample( database);
        deleteOneParrot(parrots, "Captain Squawk");

    }

    public static void zooSave(MongoCollection<Document> collection) {

        Document parrot = new Document("name", "Just Pirate")
                .append("age", 3).append("color", "green");

        List<String> favoriteWords = new ArrayList<>();
        favoriteWords.add("Hello!");
        favoriteWords.add("Polly doesn't  want a cracker!");
        favoriteWords.add("I'm a big pirate!");
        parrot.append("favoriteWords", favoriteWords);

        collection.insertOne(parrot);
        System.out.println("Parrot stored: " + parrot.toJson());
    }

    public static Document findInZoo(MongoCollection<Document> collection, String name) {

        Document parrot = new Document("name", name);

        Document res = collection.find(parrot).first();
        return res;
    }

    public static void favoriteWords(MongoDatabase database) {
        MongoCollection<Document> parrots = database.getCollection("parrots");

        AggregateIterable<Document> result = parrots.aggregate(Arrays.asList(
                new Document("$unwind", "$favoriteWords"),
                new Document("$group", new Document("_id", null)
                        .append("distinctWords", new Document("$addToSet", "$favoriteWords"))),
                new Document("$project", new Document("_id", 0).append("distinctWords", 1))
        ));

        // Print results
        for (Document doc : result) {
            System.out.println("Distinct Favorite Words: " + doc.get("distinctWords"));
        }
    }

    public static void findByFavoriteWord(MongoDatabase database, String word) {
        MongoCollection<Document> parrots = database.getCollection("parrots");
        // eq - equal
        // lt  - less then
        // lte - lesst then or equal
        // gt   - greater then
        //  gte  - greater or equal
        // in  -  arrray  [green, red]

        // Bson filter = Filters.eq("favoriteWords", word);

        Bson filter = Filters.eq("name", "Just Pirate");
        filter = Filters.eq("favoriteWords", word);
        filter = Filters.gte("age", 3);

        filter = Filters.and(
                Filters.gte("age", 3),
                Filters.eq("favoriteWords", "HI!")
        );

        filter = Filters.or(
                Filters.gte("age", 2),
                Filters.eq("favoriteWords", "HI!")
        );
        //DATASET:
        // 3      "Hello!"
        // 5      "HI!"

        // true ||  false    == true
        // true ||  true    == true

        FindIterable<Document> results = parrots.find(filter);

        for (Document doc : results) {
            System.out.println("Found Parrot by favorite word : " + doc.toJson());
        }
    }

    public static void updateParrotSample(MongoDatabase database) {
        MongoCollection<Document> parrots = database.getCollection("parrots");


        Bson filter = Filters.eq("name", "Captain Squawk");

        Bson updates = Updates.combine(Updates.set("age", 9),
                Updates.addToSet("favoriteWords", "Arrr! I'm a  big pirate!"));


        parrots.updateOne(filter, updates);

        System.out.println("Parrot updated!");
        //,
        //
        //
    }

    public static void deleteOneParrot(MongoCollection<org.bson.Document> parrots, String name) {

        Bson filter = Filters.eq("name", name);

        parrots.deleteOne(filter);

        System.out.println("Parrot deleted!");
    }

    public static void findAndParseAndOut(MongoCollection<Document> parrots) {
        Document doc = findInZoo(parrots, "Captain Squawk");
        System.out.println(doc.toJson());
        Object objectName = doc.get("name");
        String stringedName = (String) doc.get("name");
        String name = doc.getString("name");
        System.out.println("resultName : " + name);
        Integer age = doc.getInteger("age");
        System.out.println("age  : " + age);
        ObjectId oid = doc.getObjectId("_id");
        System.out.println("oid  : " + oid.toHexString());
    }


}
