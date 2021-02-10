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
public class SearchUserController {
    List<Admin> admin = new ArrayList<>();
    private UserAdminRepo userAdminRepo;
    @Autowired
    public SearchUserController(UserAdminRepo userAdminRepo) {
        this.userAdminRepo = userAdminRepo;
    }

    @GetMapping("/searchUser")
    public String findUserAdminController(Model model){
        for(Admin s:admin){
        model.addAttribute("fUserAd",userAdminRepo.findAllByFamily(s.getFamily()));}
        return "searchUser";
    }

    @GetMapping("/editUserAdmin")
    public String userAdminControllerGet(Model model){
        model.addAttribute("fUserAd",userAdminRepo.findAll());
        return "editUserAdmin";
    }
    @PostMapping("/editUserAdmin")
    public String searchUserAdminControllerPost(Model model,@RequestParam(name = "family")String family){
        admin = userAdminRepo.findAllByFamily(family);
//        model.addAttribute("searchUserAd", admin);
//        model.addAttribute("searchUserAd",userAdminRepo.findAllByFamily(family));
        return"redirect:/searchUser";
    }
    }

