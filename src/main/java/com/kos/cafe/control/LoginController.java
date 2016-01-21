package com.kos.cafe.control;


import com.kos.cafe.domain.User;
import com.kos.cafe.service.UserService;
import com.kos.cafe.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/loginpage")
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }







/*
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid final UserDTO userDto, final HttpServletRequest request, final Errors errors) {


        final User registered = createUserAccount(userDto);
        if (registered == null) {
            // result.rejectValue("email", "message.regError");
            return new ModelAndView("register", "user", userDto);
        }

        return new ModelAndView("login");
    }
*/
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
