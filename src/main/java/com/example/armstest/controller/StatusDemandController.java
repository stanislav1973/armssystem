package com.example.armstest.controller;

import com.example.armstest.Demand;
import com.example.armstest.StatusDemand;
import com.example.armstest.data.DemandRepo;
import com.example.armstest.data.StatusDemandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/statusDemand")
public class StatusDemandController {
    private StatusDemandRepo statusDemandRepo;
    private DemandRepo demandRepo;
    @Autowired
    public StatusDemandController(StatusDemandRepo statusDemandRepo) {
        this.statusDemandRepo = statusDemandRepo;
    }
    @ModelAttribute(name = "demand")
    public Demand demand(){
       return  new Demand();
    }
    @GetMapping("/statusDemand")
    public String statusDemandController(Model model){
        model.addAttribute("statusDemand",statusDemandRepo.findAll());
        return "statusDemand";
    }
    @PostMapping("/statusDemand")
    public String postStatusDemandController(@ModelAttribute Demand demand){
        return "redirect:/tableDemand";
    }

}
