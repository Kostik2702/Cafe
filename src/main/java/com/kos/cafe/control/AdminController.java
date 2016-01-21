package com.kos.cafe.control;

import com.kos.cafe.domain.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(ModelAndView model){

        ModelAndView modelAndView = new ModelAndView("admin");

        return modelAndView;
    }
}
