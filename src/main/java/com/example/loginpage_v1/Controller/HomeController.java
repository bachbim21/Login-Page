package com.example.loginpage_v1.Controller;

import com.example.loginpage_v1.Model.UserDts;
import com.example.loginpage_v1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signin")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

   @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDts userDts, HttpSession session){
        boolean f = userService.checkEmail(userDts.getEmail());
        if (f){
            session.setAttribute("msg","Email existed !!!!");
        }else {
            UserDts userDts1 = userService.createUser(userDts);
            session.setAttribute("msg", "Successfully");
        }

        return "redirect:/register";
    }

}
