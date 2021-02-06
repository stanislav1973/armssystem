package com.example.armstest.controller;

import com.example.armstest.Demand;
import com.example.armstest.StatusDemand;
import com.example.armstest.data.DemandRepo;
import com.example.armstest.data.JpaDemandRepo;
import com.example.armstest.data.StatusDemandRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/demandForm")
public class DemandController {

    private DemandRepo demandRepo;
    private StatusDemandRepo statusDemandRepo;
    private JpaDemandRepo jpaDemandRepo;
    @Autowired
    private  DemandController(DemandRepo demandRepo,StatusDemandRepo statusDemandRepo) {
        this.demandRepo = demandRepo;
        this.statusDemandRepo = statusDemandRepo;
    }

    @GetMapping
    public String demandForms(Model model){
        model.addAttribute("demand",new Demand());
        return "demandForm";
    }
    @ModelAttribute(name = "statusDemands")
    public StatusDemand statusDemands(){
        return new StatusDemand();
    }
    @PostMapping
    public String sendMessage(@Valid Demand demand, @ModelAttribute StatusDemand statusDemands){

        demand.setAccepted("принята");
        Demand f  = demandRepo.save(demand);
            statusDemands.setDemand_id(f.getId());
            statusDemands.setDemand_list_id(f.getId());
        log.info("TESTING " + statusDemands);
            statusDemandRepo.save(statusDemands);
            return "redirect:/index";
    }

}
