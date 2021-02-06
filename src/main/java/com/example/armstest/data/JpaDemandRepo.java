package com.example.armstest.data;

import com.example.armstest.Demand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaDemandRepo {
    private DemandRepo demandRepo;
    @Autowired
    public JpaDemandRepo(DemandRepo demandRepo) {
        this.demandRepo = demandRepo;
    }
public void editDemand(Demand demand) {

}
}
