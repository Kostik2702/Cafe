package com.kos.cafe.service;

import com.kos.cafe.dao.PhotoDAO;
import com.kos.cafe.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoDAO dao;
    @Override
    public Photo create(String name, byte[] body) {

        return dao.create(new Photo(name,body));
    }

    @Override
    public void remove(long id) {
        dao.delete(id);
    }

    @Override
    public Photo read(long id) {
        return dao.read(id);
    }

    @Override
    public List<Photo> readAllPhotos() {
        return dao.readAll();
    }
}
