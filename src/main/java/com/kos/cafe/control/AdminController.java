package com.kos.cafe.control;

import com.kos.cafe.domain.News;
import com.kos.cafe.domain.NewsDTO;
import com.kos.cafe.service.CommentsServiceImpl;
import com.kos.cafe.service.NewsServiceImpl;
import com.kos.cafe.valid.NewsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CommentsServiceImpl commentsService;
    @Autowired
    NewsServiceImpl newsService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(ModelAndView model){

        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("user", getPrincipal());

        return modelAndView;
    }

    @RequestMapping(value = "/comments",method = RequestMethod.GET)
    public ModelAndView commentsList(ModelAndView model){

        ModelAndView modelAndView = new ModelAndView("commentsAdm");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("commentsList",commentsService.readAll());
        return modelAndView;

    }

    @RequestMapping(value = "/addnews",method = RequestMethod.GET)
     public ModelAndView addNewsPage(ModelAndView model){

        ModelAndView modelAndView = new ModelAndView("addnews");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("news", new NewsDTO());
        return modelAndView;
    }

    @RequestMapping(value = "/addnews",method = RequestMethod.POST)
    public String  addNews(ModelAndView model,
                                @ModelAttribute(value = "news")NewsDTO newsDTO,
                                HttpServletRequest request,
                                HttpServletResponse response){
        model.addObject("user",getPrincipal());
        String messg = NewsValidator.valid(newsDTO);
        if (messg.equals("")){
            News check = newsService.create(newsDTO.getSubject(), newsDTO.getText());
            if (check!=null){


                return "redirect:/admin";
            }   else {


                model.addObject("errmsg", "error in process");
                return "redirect:/admin?err";
            }
        } else {

            model.addObject("user", getPrincipal());
            model.addObject("errmsg", messg);
            return "redirect:/admin?err";
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
