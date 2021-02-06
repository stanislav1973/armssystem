package com.example.armstest;

import com.example.armstest.data.DemandRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArmstestApplicationTests {
    @Autowired
    public DemandRepo demandRepo;
    @Test
    void contextLoads() {
    }
    @Test
    void findSizeDemand(){
        List<Demand> demand = new ArrayList<>();
        demandRepo.findAll().forEach(demand::add);
        int l = (demand.size())+1;
        long test = demand.get(l).getId();
        assertEquals(test,0);
    }

}
