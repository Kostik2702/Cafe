package com.kos.cafe.control;

import com.kos.cafe.domain.User;
import com.kos.cafe.domain.enums.UserRoleEnum;
import com.kos.cafe.service.UserServiceImpl;
import com.kos.cafe.valid.UserInfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller

public class RegisterController {

    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public BCryptPasswordEncoder encoder;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();

        model.put("userForm", userForm);



        return "register";
    }

    @RequestMapping(value = "/register")

    public String  registerUserAccount(@ModelAttribute("userForm") User user,
                                       HttpServletRequest request, HttpServletResponse response, Model model){
        String check = UserInfoValidator.valid(user);
        if (check.equals("")) {

            {
                user.setRole(UserRoleEnum.USER.name());
                String pass = user.getPassword();
                user.setPassword(encoder.encode(pass));
                if (userService.registerNewUser(user) != null) {

                    return "redirect:/";//success
                } else {

                    return "redirect:/loginpage";//exist email or login duplicate
                }


            }
        }   else {
            model.addAttribute("message",check);
            return "redirect:/reg?error";//invalid input data

        }
    }

    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public String viewRegistration(Model model) {






        return "badinfo";
    }



}
