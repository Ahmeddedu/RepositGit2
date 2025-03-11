package first.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleStoreImpl implements ArticleStore {

    private ArticlesCollection collection;

    @Override
    public List<Article> getArticles() {
        ArrayList<Article> res = new ArrayList<>(collection.getArticles());

        res.add(new Article("super news today!", "long and not very interesting but very detailed news description"));
        return res;
    }

    @Override
    public synchronized void addArticle(Article a) {
        collection.getArticles().add(a);
        persist();
    }

    @Override
    public synchronized void removeArticle(Article a) {
        collection.getArticles().remove(a);
        persist();
    }

    @PostConstruct
    public synchronized void initStore() {
        if (collection != null) {
            return;
        }
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("output.json"));
            ObjectMapper m = new ObjectMapper();
            collection = m.readValue(bytes, ArticlesCollection.class);
        } catch (IOException e) {
            collection = new ArticlesCollection();
            collection.setArticles(new ArrayList<>());
            System.out.println("io exception" + e.getMessage());
        }
    }

    public synchronized void persist() {
        Path filePath = Paths.get("output.json");

        ObjectMapper m = new ObjectMapper();

        String content = null;
        try {
            content = m.writeValueAsString(collection);
            Files.write(filePath, content.getBytes());
            System.out.println("Successfully written to file: " + filePath.toAbsolutePath());

        } catch (JsonProcessingException e) {
            System.err.println("Error : " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
