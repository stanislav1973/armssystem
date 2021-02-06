package com.example.armstest;

import com.example.armstest.data.DemandRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Slf4j
@SpringBootTest
class ArmstestApplicationTests {
    @Autowired
    public DemandRepo demandRepo;
    @Test
    void contextLoads() {
    }
    @Test
    void findSizeDemand(){
//        StatusDemand st = new StatusDemand();
//        Demand d= new Demand();
//        for(Demand demand:d.getDemandList()){
//            st.setDemand_id(demand.getId());
//            assertEquals(demand.getId(),2);
//        }

    }
//    @Test
//    void findSizeDemand1(){
//        StatusDemand st = new StatusDemand();
//        Demand d= new Demand();
//        for(Demand demand:d.getDemandList()){
//            st.setDemand_id(demand.getId());
//            assertEquals(demand.getId(),3);
//        }

//    }
//    @Test
//    void findSizeDemand2(){
//        StatusDemand st = new StatusDemand();
//        Demand d= new Demand();
//        for(Demand demand:d.getDemandList()){
//            log.info("Test " + demand);
//        }

//    }
}
