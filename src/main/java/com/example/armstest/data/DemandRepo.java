package com.example.armstest.data;


import com.example.armstest.Demand;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepo extends CrudRepository<Demand,Long> {
}

