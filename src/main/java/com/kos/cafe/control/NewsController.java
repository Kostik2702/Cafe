package com.kos.cafe.control;

import com.kos.cafe.domain.News;
import com.kos.cafe.domain.NewsPreview;
import com.kos.cafe.service.NewsService;
import com.kos.cafe.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsServiceImpl newsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(Model model){
        ModelAndView modelAndView = new ModelAndView("news");
        List<News> newsListE = newsService.readAll();
        ArrayList<NewsPreview> previews = new ArrayList<NewsPreview>();
        for (News news:newsListE){
            previews.add(new NewsPreview(news.getSubject(),news.getText(),news.getId()));
        }
        modelAndView.addObject("previevs",previews);
        modelAndView.addObject("user", getPrincipal());
        return modelAndView;

    }

    @RequestMapping(value = "/newsFull" , method = RequestMethod.GET)
    public ModelAndView newsPageFullItem(Model model,
                               @RequestParam(value = "news") long id) {
        ModelAndView modelAndView = new ModelAndView("fullnews");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("news",newsService.read(id));
        return modelAndView;
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
