package com.kos.cafe.control;

import com.kos.cafe.domain.Comment;
import com.kos.cafe.domain.CommentDTO;
import com.kos.cafe.service.CommentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentsServiceImpl commentsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(ModelAndView model){
        ArrayList<Comment> comments = (ArrayList<Comment>) commentsService.readAll();
        ModelAndView modelAndView = new ModelAndView("comments");
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.GET)
    public String addCommentPage(Map<String, Object> model) {
        model.put("user", getPrincipal());
        model.put("comment", new CommentDTO());
        return "addcomment";
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addComment(HttpServletRequest request,
                             HttpServletResponse response,
                             @ModelAttribute(value = "comment") CommentDTO commentDTO,
                             ModelAndView model) {
        model.addObject("user", getPrincipal());
        Comment ready = commentsService.createComment(commentDTO.getText(), getPrincipal());
        if (ready!=null){
            ArrayList<Comment> comments = commentsService.readAll();
            model.addObject("comments", comments);
            return "redirect:/comments";
        }   else {
            return "redirect:/comments?error";
        }
    }


    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
