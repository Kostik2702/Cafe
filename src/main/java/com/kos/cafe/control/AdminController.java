package com.kos.cafe.control;

import com.kos.cafe.domain.News;
import com.kos.cafe.domain.NewsDTO;
import com.kos.cafe.domain.Photo;
import com.kos.cafe.domain.PhotoDTO;
import com.kos.cafe.service.CommentsServiceImpl;
import com.kos.cafe.service.NewsServiceImpl;
import com.kos.cafe.service.PhotoService;
import com.kos.cafe.valid.NewsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CommentsServiceImpl commentsService;
    @Autowired
    NewsServiceImpl newsService;
    @Autowired
    PhotoService photoService;


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

    @RequestMapping(value = "/addphoto",method = RequestMethod.GET)
    public ModelAndView addPhotoPage(ModelAndView model){
        ModelAndView modelAndView = new ModelAndView("addphoto");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("photoDTO", new PhotoDTO());
        return modelAndView;
    }

    @RequestMapping(value = "/addphoto",method = RequestMethod.POST)
    public String  addPhoto(ModelAndView model,
                           @ModelAttribute(value = "photoDTO") PhotoDTO inputPhotoDTO,
                           HttpServletRequest request,
                           HttpServletResponse response){
        if (inputPhotoDTO.getPhoto() == null){
            model.addObject("user", getPrincipal());
            return "redirect:/admin?err";
        } else {
            try {
                Photo photo = photoService.create(inputPhotoDTO.getPhoto().getOriginalFilename(), inputPhotoDTO.getPhoto().getBytes());
                if (photo!=null){
                    return "redirect:/admin?success";
                } else {
                    return "redirect:/admin?err";
                }


            } catch (IOException e) {
                e.printStackTrace();
                return "redirect:/admin?err";
            }
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
