package com.kos.cafe.service;


import com.kos.cafe.domain.EditUserDTO;
import com.kos.cafe.domain.User;

import java.sql.SQLException;
import java.util.List;


public interface UserService {

    User getUser(String login);
    User getUser(long id);
    User getUserByMail(String email) throws SQLException;

    User registerNewUser(User user);
    List<User> getAll();
    void delete(long id);
    void update(EditUserDTO dto);
}
