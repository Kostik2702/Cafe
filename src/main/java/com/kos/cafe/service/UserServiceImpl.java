package com.kos.cafe.service;


import com.kos.cafe.dao.UserDAO;
import com.kos.cafe.dao.UserDaoImpl;
import com.kos.cafe.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDAO;

    @Override
    public User getUser(String login) {
        User user = null;
        try {
            user = userDAO.read(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public User registerNewUser(User user)  {
        boolean logCheck = usernameExcepted(user.getLogin());
        boolean mailCheck = emailExcepted(user.getEmail());
        if (logCheck && mailCheck) {

            return userDAO.createUser(user);
        } else {
            return null;
        }


    }



    public UserDaoImpl getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDaoImpl userDAO) {
        this.userDAO = userDAO;
    }

    private boolean usernameExcepted(String login){
        try {
            User user = userDAO.read(login);
            if (user == null){
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    private boolean emailExcepted (String email){
        try {
            User user = userDAO.readByEmail(email);
            if (user == null){
                return true;
            }
        } catch (SQLException e) {

        }
        return false;

    }
}
