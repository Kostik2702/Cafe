package com.kos.cafe.dao;


import com.kos.cafe.domain.User;

import java.sql.SQLException;

public interface UserDAO {
    User createUser(User user);
    User read (String login) throws SQLException;
    User readByEmail (String email) throws SQLException;
    void update(User user);

}
