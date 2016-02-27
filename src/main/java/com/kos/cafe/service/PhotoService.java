package com.kos.cafe.service;


import com.kos.cafe.domain.Photo;

import java.util.List;

public interface PhotoService {
    Photo create (String name, byte[] body);
    void remove(long id);
    Photo read(long id);
    List<Photo> readAllPhotos();

}
