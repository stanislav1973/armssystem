package com.example.armstest.data;

import com.example.armstest.Admin;
import org.springframework.data.repository.CrudRepository;

public interface UserAdminRepo extends CrudRepository<Admin,Long> {
}
