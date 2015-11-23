package com.kos.cafe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class MainController {


    @RequestMapping(value = "/")
    public ModelAndView Main() {
        return new ModelAndView("index");
    }

}
