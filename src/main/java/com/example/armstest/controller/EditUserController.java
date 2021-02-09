package com.example.armstest.controller;

import com.example.armstest.Admin;
import com.example.armstest.data.UserAdminRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
public class EditUserController {
    List<Admin> admin = new ArrayList<>();
    private UserAdminRepo userAdminRepo;
    @Autowired
    public EditUserController(UserAdminRepo userAdminRepo) {
        this.userAdminRepo = userAdminRepo;
    }

    @GetMapping("/searchUser")
    public String findUserAdminController(Model model,String family){
        for(Admin s:admin){
        model.addAttribute("fUserAd",userAdminRepo.findAllByFamily(s.getFamily()));}
        return "searchUser";
    }

    @GetMapping("/editUserAdmin")
    public String userAdminControllerGet(Model model){
        model.addAttribute("fUserAd",userAdminRepo.findAll());
        model.addAttribute("userAd",new Admin());
        return "editUserAdmin";
    }
    @PostMapping("/editUserAdmin")
    public String searchUserAdminControllerPost(Model model,@RequestParam(name = "family")String family){
        log.info("Test "  + family);
        admin = userAdminRepo.findAllByFamily(family);
        log.info("Test "  + admin);
//        model.addAttribute("searchUserAd", admin);
//        model.addAttribute("searchUserAd",userAdminRepo.findAllByFamily(family));
        return"redirect:/searchUser";
    }
//    @PostMapping("/editUserAdmin")
//    public String userAdminControllerPost(){
//        return "redirect:/searchUser";
//    }
}

