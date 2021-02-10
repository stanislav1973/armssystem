package com.example.armstest.controller;

import com.example.armstest.data.DeviceNameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deviceName")
public class DeviceController {
    private DeviceNameRepo deviceNameRepo;
    @Autowired
    public DeviceController(DeviceNameRepo deviceNameRepo) {
        this.deviceNameRepo = deviceNameRepo;
    }

    @GetMapping
public String deviceNameController(Model model){
    model.addAttribute("deviceC",deviceNameRepo.findAll());
    return "deviceName";
}
}