package com.example.armstest.controller;

import com.example.armstest.Admin;
import com.example.armstest.data.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/addUser")
public class AddUserController {

    private AdminRepo adminRepo;
    @Autowired
    public AddUserController(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @GetMapping
    public String getControllerUser(Model model) {
        model.addAttribute("userS",new Admin());
        return "addUser";
    }

    @PostMapping
    public String postControllerUser(@Valid Admin admin){
        adminRepo.save(admin);
        return "redirect:/tableDemand";
    }
}
