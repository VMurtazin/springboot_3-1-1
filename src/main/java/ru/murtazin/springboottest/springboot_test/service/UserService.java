package ru.murtazin.springboottest.springboot_test.service;



import ru.murtazin.springboottest.springboot_test.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void removeUserById (long id);
    void update (User user);

    User getUserById(long id);
    User findByUsername(String username);
    List<User> getAllUsers();

}
