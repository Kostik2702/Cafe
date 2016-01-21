package com.kos.cafe.dao;


import com.kos.cafe.domain.Comment;

import java.util.List;

public interface CommentDAO {

    Comment create(Comment comment);
    List<Comment> readAll();
    Comment read(long id);
    void delete(long id);

}
