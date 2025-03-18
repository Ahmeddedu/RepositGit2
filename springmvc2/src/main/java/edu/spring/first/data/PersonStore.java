package edu.spring.first.data;

import java.util.List;

public interface PersonStore {
    List<Person> getPeople();
    void addPerson(Person p);
    void removePerson(Person p);
}