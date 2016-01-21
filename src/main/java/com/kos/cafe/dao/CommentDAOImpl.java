package com.kos.cafe.dao;


import com.kos.cafe.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CommentDAOImpl implements CommentDAO{

    @Autowired
    EntityManager em;
    @Override
    public Comment create(Comment comment) {
        em.getTransaction().begin();
        em.persist(comment);
        em.getTransaction().commit();
        return comment;
    }

    @Override
    public List<Comment> readAll() {
        Query query = em.createQuery("SELECT c FROM Comment c ", Comment.class);
        List<Comment> comments = query.getResultList();
        return comments;
    }

    @Override
    public Comment read(long id) {
        Comment res = em.find(Comment.class, id);
        return res;
    }

    @Override
    public void delete(long id) {
        Comment comment = em.find(Comment.class, id);
        em.getTransaction().begin();
        em.remove(comment);
        em.getTransaction().commit();
    }

}
