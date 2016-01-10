package com.kos.cafe.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model){
        return "reserve";
    }

    @RequestMapping(value = {  "/action" }, method = RequestMethod.GET)
    public String newsPageFull(Model model) {
        model.addAttribute("user", getPrincipal());
        return "reserveready";
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
