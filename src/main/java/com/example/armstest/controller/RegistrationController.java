package com.example.armstest.controller;

import com.example.armstest.data.AdminRepo;
import com.example.armstest.security.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private AdminRepo adminRepo;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public RegistrationController(AdminRepo adminRepo,PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.adminRepo = adminRepo;
    }
    @GetMapping
    public String registration(){
        return"registration";
    }
    @PostMapping
    public String registrations(RegistrationForm form){
        adminRepo.save(form.toAdmin(passwordEncoder));
        return "redirect:/login";
    }
}
