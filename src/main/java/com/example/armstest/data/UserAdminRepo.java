package com.example.armstest.data;

import com.example.armstest.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAdminRepo extends CrudRepository<Admin,Long> {
    List<Admin> findAllByFamily(String family);
}
//@Param("family")