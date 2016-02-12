package com.kos.cafe.service;

import com.kos.cafe.dao.NewsDAOImpl;
import com.kos.cafe.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hrytsuk.K.O on 12.02.2016.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDAOImpl newsDAO;

    @Override
    public News create(String subject, String text) {
        return newsDAO.create(new News(subject,text));
    }

    @Override
    public News read(String subject) {
        return newsDAO.read(subject);
    }

    @Override
    public News read(long id) {
        return newsDAO.read(id);
    }

    @Override
    public List<News> readAll() {
        return newsDAO.readAll();
    }

    @Override
    public void delete(long id) {
        newsDAO.delete(id);
    }
}
