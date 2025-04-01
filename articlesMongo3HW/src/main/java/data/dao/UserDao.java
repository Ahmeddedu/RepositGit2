package data.dao;

import data.dto.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> findAllUsers();

    User findByName(String name);
}
