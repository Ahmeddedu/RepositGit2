package edu.articles.dao;

import edu.articles.dto.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> findAllUsers();

    User findByName(String name);
}
