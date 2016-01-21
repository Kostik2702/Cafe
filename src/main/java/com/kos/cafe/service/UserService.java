package com.kos.cafe.service;


import com.kos.cafe.domain.User;


public interface UserService {

    User getUser(String login);
    User registerNewUser(User user);
}
