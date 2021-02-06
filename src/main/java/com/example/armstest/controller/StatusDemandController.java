package com.example.armstest.controller;

import com.example.armstest.Demand;
import com.example.armstest.StatusDemand;
import com.example.armstest.data.DemandRepo;
import com.example.armstest.data.StatusDemandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        model.addAttribute("statusDemandD",statusDemandRepo.findAll());
        return "statusDemand";
    }
    @GetMapping("/editStatusDemand/{id}")
    public String statusDemandControllerId(@PathVariable("id") long id,Model model){
        StatusDemand statusDemand = statusDemandRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Exception" + id));
        model.addAttribute("statusD",statusDemand);
        return "statusDemand";
    }

    @PostMapping("/editStatusDemand/{id}")
    public String postStatusDemandController(@PathVariable("id") long id, @Valid StatusDemand statusDemand){
        statusDemandRepo.save(statusDemand);
        return "redirect:/statusDemand";
    }


    @GetMapping("/deleteStatusDemand/{id}")
    public String deleteDemand(@PathVariable("id") long id) {
        StatusDemand statusDemand = statusDemandRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        statusDemandRepo.delete(statusDemand);
        return "redirect:/tableDemand";
    }
}
