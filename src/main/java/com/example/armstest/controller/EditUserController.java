package com.example.armstest.controller;

import com.example.armstest.data.UserAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class EditUserController {
    private UserAdminRepo userAdminRepo;

    @GetMapping("/editUserAdmin")
    public String userAdminControllerGet(Model model){
        model.addAttribute("userAd",userAdminRepo.findAll());
        return "edithUserAdmin";
    }
    @PostMapping("/editUserAdmin")
    public String userAdminControllerPost(){
        return "";
    }
}


