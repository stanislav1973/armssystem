package com.example.armstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/devicename")
public class DeviceController {

@GetMapping
public String deviceNameController(Model model){
    //model.addAttribute("deviceC",)
    return "devicename";
}
}