package com.kos.cafe.service;

import com.kos.cafe.dao.CommentDAOImpl;
import com.kos.cafe.dao.UserDaoImpl;
import com.kos.cafe.domain.Comment;
import com.kos.cafe.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    UserDaoImpl userDao;
    @Autowired
    CommentDAOImpl commentDAO;

    @Override
    public Comment createComment(String message, String login) {
        Comment comment = new Comment();
        comment.setCommentText(message);
        comment.setDate(new Date());
        try {
            User current = userDao.read(login);
            current.addComment(comment);
            userDao.update(current);
            return comment;
        } catch (SQLException e) {

            return null;
        }
    }

    @Override
    public ArrayList<Comment> readAll() {
       ArrayList<Comment> res = (ArrayList<Comment>) commentDAO.readAll();
        return res;
    }

    @Override
    public void delete(long id) {
        commentDAO.delete(id);
    }

}
