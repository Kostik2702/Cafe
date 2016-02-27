package com.kos.cafe.service;


import com.kos.cafe.domain.Comment;

import java.util.ArrayList;
import java.util.List;

public interface CommentsService {

    Comment createComment(String message, String login);
    ArrayList<Comment> readAll();
    void delete(long id);

}
