package com.example.armstest.controller;

import com.example.armstest.data.UserAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchUserAdminController {
    private UserAdminRepo userAdminRepo;
    @Autowired
    public SearchUserAdminController(UserAdminRepo userAdminRepo) {
        this.userAdminRepo = userAdminRepo;
    }

    @GetMapping("/searchUserAdmin")
    public String userAdminControllerGet(Model model){
        model.addAttribute("userAd",userAdminRepo.findAll());
        return "searchUserAdmin";
    }
    @PostMapping("/searchUserAdmin")
    public String userAdminControllerPost(){
        return "";
    }
}
