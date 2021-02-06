package com.example.armstest.controller;
import com.example.armstest.Admin;
import com.example.armstest.data.AdminRepo;
import com.example.armstest.security.RegistrationForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import com.example.armstest.Demand;
import com.example.armstest.data.DemandRepo;
import com.example.armstest.data.JpaDemandRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
public class TableDemandController {
PasswordEncoder passwordEncoder;
    private AdminRepo adminRepo;
    private DemandRepo demandRepo;
    @Autowired
    public TableDemandController(DemandRepo demandRepo) {
        this.demandRepo = demandRepo;


    }

    @GetMapping("/tableDemand")
    public String tableDemand(Model model) {
        model.addAttribute("tDemand", demandRepo.findAll());
        return "tableDemand";
    }

    //edit table Demand get post request
    @GetMapping("/editTableDemand/{id}")
    public String tableDemandEdit(@PathVariable("id") long id, Model model) throws Throwable {
        Demand demand = demandRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Exception" + id));
        model.addAttribute("editTable", demand);
        return "editTableDemand";
    }

    @PostMapping("/editTableDemand/{id}")
    public String tableDemandEditPut(@PathVariable("id") long id, @Valid Demand demand) { ;
    List<Demand>list = new ArrayList<>();
        demandRepo.findAll().forEach(list::add);
        for(Demand d:list){
            demand.setDemand_desc(d.getDemand_desc());
            demand.setUser(d.getUser());
            demand.setTime(d.getTime());
            demand.setOffice(d.getOffice());
            demand.setStatus(d.getStatus());
        }
         demandRepo.save(demand);
        return "redirect:/tableDemand";
    }
    @GetMapping("/deleteDemand/{id}")
    public String deleteDemand(@PathVariable("id") long id, Model model) {
        Demand demand = demandRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        demandRepo.delete(demand);
        return "redirect:/tableDemand";
    }

}
