package com.kos.cafe.service;


import com.kos.cafe.domain.User;

import java.util.List;


public interface UserService {

    User getUser(String login);
    User getUser(long id);
    User registerNewUser(User user);
    List<User> getAll();
    void delete(long id);
}
