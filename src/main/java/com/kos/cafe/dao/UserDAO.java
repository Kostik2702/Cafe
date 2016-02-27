package com.kos.cafe.dao;


import com.kos.cafe.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    User createUser(User user);
    User read (String login) throws SQLException;
    User read (long id) throws SQLException;
    User readByEmail (String email) throws SQLException;
    void update(User user);
    List<User> readAll();
    void delete(long id);

}
