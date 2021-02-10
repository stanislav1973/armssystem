package com.example.armstest.controller;

import com.example.armstest.Admin;
import com.example.armstest.data.UserAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EditUserController {
    private UserAdminRepo userAdminRepo;
    @Autowired
    public EditUserController(UserAdminRepo userAdminRepo) {
        this.userAdminRepo = userAdminRepo;
    }

    @GetMapping("/editUser/{id}")
    public String editUserController(@PathVariable("id") long id,Model model){
        Admin admin = userAdminRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Exception" + id));
        model.addAttribute("editUserU",admin);
        return "editUser";
    }
    @PostMapping("/editUser/{id}")
    public String editUserControllerPost(@PathVariable("id") long id, @Valid Admin admin){
        userAdminRepo.save(admin);
        return "redirect:/editUserAdmin";
    }
}
