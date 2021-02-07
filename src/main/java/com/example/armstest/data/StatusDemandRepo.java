package com.example.armstest.data;

import com.example.armstest.StatusDemand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDemandRepo extends CrudRepository<StatusDemand,Long> {
//@Query("update StatusDemand d set d.master = :master where d.id = :id")
//    public void saveMaster(StatusDemand statusDemand);
}
