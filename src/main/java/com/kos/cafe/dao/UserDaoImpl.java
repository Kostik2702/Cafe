package com.kos.cafe.dao;


import com.kos.cafe.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDAO {
    @Autowired
    EntityManager em;

    @Override
    public User createUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    @Override
    public User read(String login) throws SQLException{
        Query query = em.createQuery("select u FROM User u WHERE u.login LIKE :login", User.class);
        query.setParameter("login", login);
        List results = query.getResultList();
        if (results.isEmpty()){
            return null;
        } else {
            User res = (User) query.getSingleResult();
            return res;
        }
    }

    @Override
    public User readByEmail(String email) throws SQLException{
        Query query = em.createQuery("select u FROM User u WHERE u.email LIKE :email", User.class);
        query.setParameter("email", email);
        List results = query.getResultList();
        if (results.isEmpty()){
            return null;
        } else {
            User res = (User) query.getSingleResult();
            return res;
        }
    }

    @Override
    public void update(User user) {
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }   catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}
