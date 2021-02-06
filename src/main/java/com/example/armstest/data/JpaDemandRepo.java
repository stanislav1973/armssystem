package com.example.armstest.data;

import com.example.armstest.Demand;
import com.example.armstest.StatusDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaDemandRepo {
    private StatusDemandRepo statusDemandRepo;
    @Autowired
    private DemandRepo demandRepo;
    @Autowired
    public JpaDemandRepo(StatusDemandRepo statusDemandRepo) {

        this.statusDemandRepo = statusDemandRepo;
    }

    public void saveStatusDemand(Demand demand) {
        List<Demand>d = new ArrayList<>();
        demandRepo.findAll().forEach(d::add);
        long j = d.get(0).getId();
}
}
