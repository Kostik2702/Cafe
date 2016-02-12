package com.kos.cafe.dao;

import com.kos.cafe.domain.News;

import java.util.List;

/**
 * Created by Hrytsuk.K.O on 12.02.2016.
 */
public interface NewsDAO {
    News create(News news);
    News read(String subject);
    News read(long id);
    List<News> readAll();
    void delete(long id);
    void update(News news);
}
