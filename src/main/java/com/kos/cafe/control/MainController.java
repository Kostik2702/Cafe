package com.kos.cafe.control;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model){
        return "index";
    }


    @RequestMapping(value = {  "/" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "index";
    }



    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String loginp(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "login";
    }

    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String aboutus(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "aboutus";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "denied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }




    @RequestMapping(value = {  "/reserve" }, method = RequestMethod.GET)
    public String reservePage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "reserve";
    }

    @RequestMapping(value = "/ourmenu", method = RequestMethod.GET)
    public String menuPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "ourmenu";
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
