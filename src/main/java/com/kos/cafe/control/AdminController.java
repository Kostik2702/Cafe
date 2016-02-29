package com.kos.cafe.control;

import com.kos.cafe.domain.*;
import com.kos.cafe.domain.enums.UserRoleEnum;
import com.kos.cafe.service.CommentsServiceImpl;
import com.kos.cafe.service.NewsServiceImpl;
import com.kos.cafe.service.PhotoService;
import com.kos.cafe.service.UserService;
import com.kos.cafe.valid.NewsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CommentsServiceImpl commentsService;
    @Autowired
    NewsServiceImpl newsService;
    @Autowired
    PhotoService photoService;
    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder encoder;


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

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView usersList(ModelAndView model){

        ModelAndView modelAndView = new ModelAndView("userslist");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("usersList",userService.getAll());
        return modelAndView;

    }

    @RequestMapping(value = "/userProfile" , method = RequestMethod.GET)
    public ModelAndView newsPageFullItem(Model model,
                                         @RequestParam(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("userProfile");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("userItem", userService.getUser(id));
        return modelAndView;
    }

    @RequestMapping(value = "/news_list",method = RequestMethod.GET)
    public ModelAndView newsList(ModelAndView model){

        ModelAndView modelAndView = new ModelAndView("newsList");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("newsList",newsService.readAll());
        return modelAndView;

    }

    @RequestMapping(value = "/photos_list",method = RequestMethod.GET)
    public ModelAndView photosList(ModelAndView model){

        ModelAndView modelAndView = new ModelAndView("photoslist");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("photosList",photoService.readAllPhotos());
        return modelAndView;

    }

    @RequestMapping(value = "/delete_news",method = RequestMethod.GET)
    public String  deleteNews(ModelAndView model,
                                   @RequestParam(value = "id") long id){
        newsService.delete(id);

        model.addObject("user", getPrincipal());
        model.addObject("newsList",newsService.readAll());
        return "redirect:/admin/news_list";

    }

    @RequestMapping(value = "/delete_user",method = RequestMethod.GET)
    public String  deleteUser(ModelAndView model,
                              @RequestParam(value = "id") long id){
        userService.delete(id);

        model.addObject("user", getPrincipal());
        model.addObject("usersList",userService.getAll());
        return "redirect:/admin/users";

    }

    @RequestMapping(value = "/delete_comment",method = RequestMethod.GET)
    public String  deleteComment(ModelAndView model,
                              @RequestParam(value = "id") long id){

        commentsService.delete(id);
        model.addObject("user", getPrincipal());
        model.addObject("commentsList",commentsService.readAll());
        return "redirect:/admin/comments";

    }


    @RequestMapping(value = "/delete_photo",method = RequestMethod.GET)
    public String  deletePhoto(ModelAndView model,
                                 @RequestParam(value = "id") long id){

        photoService.remove(id);
        model.addObject("user", getPrincipal());
        model.addObject("photosList",photoService.readAllPhotos());
        return "redirect:/admin/photos_list";

    }

    @RequestMapping(value = "/watch_news" , method = RequestMethod.GET)
    public ModelAndView watchNews(Model model,
                                         @RequestParam(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("fullnewsAdmin");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("newsItem",newsService.read(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit_news" , method = RequestMethod.GET)
    public ModelAndView editNews(Model model,
                                  @RequestParam(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("editNews");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("newsItem",newsService.read(id));
        modelAndView.addObject("newsDTO", new EditNewsDTO(newsService.read(id).getSubject(),newsService.read(id).getText(),id));
        return modelAndView;
    }
    @RequestMapping(value = "/edit_news" , method = RequestMethod.POST)
    public String  editNewsAction(ModelAndView modelAndView,
                                 @ModelAttribute(value = "newsDTO") EditNewsDTO newsDTO

                                 ) {


        newsService.update(newsDTO, newsDTO.getId());
        return "redirect:/admin/watch_news?id="+newsDTO.getId()+"&success";

    }

    @RequestMapping(value = "/edit_user" , method = RequestMethod.GET)
    public ModelAndView editUser(Model model,
                                 @RequestParam(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("usredit");
        modelAndView.addObject("user", getPrincipal());
        modelAndView.addObject("userDTO", new EditUserDTO(userService.getUser(id).getLogin(),
                userService.getUser(id).getName(), userService.getUser(id).getSurname(),
                userService.getUser(id).getEmail(), userService.getUser(id).getRole(), id));

        ArrayList<String> roles = new ArrayList<String>();

        roles.add(UserRoleEnum.USER.name());
        roles.add(UserRoleEnum.ADMIN.name());

        for (int i = 0; i <roles.size() ; i++) {
            if (roles.get(i).equals(userService.getUser(id).getRole())){
                roles.remove(roles.get(i));
            }
        }

        modelAndView.addObject("rolesList", roles);


        return modelAndView;
    }

    @RequestMapping(value = "/edit_user" , method = RequestMethod.POST)
    public String  editUserAction(ModelAndView modelAndView,
                                  @ModelAttribute(value = "userDTO") EditUserDTO userDTO

    ) {

        userService.update(userDTO);

        return "redirect:/admin/users?success";

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
