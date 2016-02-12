package com.kos.cafe.dao;

import com.kos.cafe.domain.News;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hrytsuk.K.O on 12.02.2016.
 */
public class NewsDAOImpl implements NewsDAO{
    @Autowired
    EntityManager em;

    @Override
    public News create(News news) {
        try {
            em.getTransaction().begin();
            em.persist(news);
            em.getTransaction().commit();
            return news;
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public News read(String subject) {
        Query query =  em.createQuery("SELECT news from News news WHERE news.subject like :subject", News.class);
        query.setParameter("subject",subject);
        List results = query.getResultList();
        if (results.isEmpty()){
            return null;
        } else {
            News news = (News) query.getSingleResult();
            return news;
        }
    }

    @Override
    public News read(long id) {
        News res =  em.find(News.class,id);
        return res;
    }

    @Override
    public List<News> readAll() {
        Query query = em.createQuery("SELECT news FROM News news", News.class);
        List<News> result = query.getResultList();
        return result;
    }

    @Override
    public void delete(long id) {
        em.remove(em.find(News.class,id));
    }

    @Override
    public void update(News news) {
        try {
            em.getTransaction().begin();
            em.merge(news);
            em.getTransaction().commit();

        }   catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }

    }
}
