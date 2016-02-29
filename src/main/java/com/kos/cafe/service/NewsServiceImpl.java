package com.kos.cafe.service;

import com.kos.cafe.dao.NewsDAOImpl;
import com.kos.cafe.domain.EditNewsDTO;
import com.kos.cafe.domain.News;
import com.kos.cafe.domain.NewsDTO;
import com.kos.cafe.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public void update(EditNewsDTO dto, long id) {
        News temp = newsDAO.read(id);
        if (dto.getSubject()!=null && !dto.getSubject().equals(temp.getSubject())) {
            temp.setSubject(dto.getSubject());
        }
        if (dto.getText()!=null && !dto.getText().equals(temp.getText())){
            temp.setText(dto.getText());
        }

        newsDAO.update(temp);

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
