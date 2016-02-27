package com.kos.cafe.dao;

import com.kos.cafe.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class PhotoDAOImpl implements PhotoDAO {
    @Autowired
    EntityManager em;

    @Override
    public Photo create(Photo photo) {
        try {
            em.getTransaction().begin();
            em.persist(photo);
            em.getTransaction().commit();
            return photo;
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public Photo read(long id) {
        return em.find(Photo.class,id);
    }

    @Override
    public void delete(long id) {
        Photo temp = em.find(Photo.class, id);
        if (temp!=null){
            em.remove(temp);
        }
    }

    @Override
    public void update(Photo photo) {
        em.merge(photo);
    }

    @Override
    public List<Photo> readAll() {
        Query query = em.createQuery("SELECT p FROM Photo p", Photo.class);
        return query.getResultList();
    }
}
