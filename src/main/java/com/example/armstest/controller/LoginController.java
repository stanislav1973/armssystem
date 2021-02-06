package com.example.armstest.controller;
import com.example.armstest.Admin;
import com.example.armstest.data.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class LoginController {
    @GetMapping("/index")
    public String registerForm(@AuthenticationPrincipal Admin admin, Model model) {
        if(admin!=null){
            model.addAttribute("user",admin.getUsername());
            return "index";
        }
            model.addAttribute("user","anonymous");
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return"login";
    }

    //@PreAuthorize("hasRole('USER')")
//    @GetMapping("/user")
//    public String users(){
//        return"user";
//    }
    //@PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/tableForm")
//    public String admins(){
//        return"tableForm";
//    }
}