package edu.spring.first.data;

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
public class PersonStoreImpl implements PersonStore {

    private PeopleCollection collection;

    @Override
    public List<Person> getPeople() {
        return new ArrayList<>(collection.getPeople());
    }

    @Override
    public synchronized void addPerson(Person p) {
        collection.getPeople().add(p);
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
            collection = m.readValue(bytes, PeopleCollection.class);
        } catch (IOException e) {
            collection = new PeopleCollection();
            collection.setPeople(new ArrayList<>());
            System.out.println("io exception" + e.getMessage());
        }
    }

    public synchronized void persist() {
        Path filePath = Paths.get("output.json");

        ObjectMapper m = new ObjectMapper();

        try {
            String content = m.writeValueAsString(collection);
            Files.write(filePath, content.getBytes());
            System.out.println("Successfully written to file: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}