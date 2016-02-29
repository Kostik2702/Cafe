package com.kos.cafe.control;

import com.kos.cafe.domain.Photo;
import com.kos.cafe.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    PhotoService photoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(Model model){
        ModelAndView modelAndView = new ModelAndView("gallery");
        List<Photo> photos = photoService.readAllPhotos();

        modelAndView.addObject("photos", photos);
        modelAndView.addObject("user", getPrincipal());
        return modelAndView;
    }

    @RequestMapping(value = "/image/{photo_id}", method = RequestMethod.GET)
    public void getFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("photo_id") long fileId) throws IOException {

        byte[] content = photoService.read(fileId).getBody();
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");


            response.getOutputStream().write(content);
            response.getOutputStream().flush();
            response.getOutputStream().close();



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
