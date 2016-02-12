package com.kos.cafe.service;

import com.kos.cafe.domain.News;

import java.util.List;

public interface NewsService {
    News create(String subject, String text);
    News read (String subject);
    News read (long id);
    List<News> readAll ();
    void delete(long id);

}
