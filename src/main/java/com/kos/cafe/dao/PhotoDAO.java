package com.kos.cafe.dao;


import com.kos.cafe.domain.Photo;

import java.util.List;

public interface PhotoDAO {

    Photo create(Photo photo);
    Photo read(long id);
    void delete(long id);
    void update(Photo photo);
    List<Photo>  readAll();
}
