package com.example.armstest.data;

import com.example.armstest.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends CrudRepository<Admin,Long> {
    Admin findByUsername(String username);
}
