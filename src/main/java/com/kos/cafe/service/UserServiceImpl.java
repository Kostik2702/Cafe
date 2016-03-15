package com.kos.cafe.service;


import com.kos.cafe.dao.UserDAO;
import com.kos.cafe.dao.UserDaoImpl;
import com.kos.cafe.domain.Comment;
import com.kos.cafe.domain.EditUserDTO;
import com.kos.cafe.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDAO;
    @Autowired
    CommentsService commentsService;
    @Autowired
    BCryptPasswordEncoder encoder;

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
    public User getUser(long id)  {
        try {
            return userDAO.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByMail(String email) throws SQLException {
        return userDAO.readByEmail(email);
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

    @Override
    public List<User> getAll() {
        return userDAO.readAll();
    }

    @Override
    public void delete(long id) {
        try {
            if (userDAO.read(id).getComments().isEmpty()){
                userDAO.delete(id);
            }   else {
                User temp = userDAO.read(id);
                for (Comment comment:temp.getComments()){
                    commentsService.delete(comment.getId());
                }

                userDAO.delete(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(EditUserDTO dto) {
        try {
            User temp = userDAO.read(dto.getId());
            temp.setLogin(dto.getLogin());
            temp.setPassword(encoder.encode(dto.getPassword()));
            temp.setName(dto.getName());
            temp.setSurname(dto.getSurname());
            temp.setEmail(dto.getEmail());
            temp.setRole(dto.getRole());
            userDAO.update(temp);
        } catch (SQLException e) {
            e.printStackTrace();
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
