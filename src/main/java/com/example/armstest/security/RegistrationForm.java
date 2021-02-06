package com.example.armstest.security;

import com.example.armstest.Admin;
import com.example.armstest.Role;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Data
public class RegistrationForm {

    private String password;
    private String username;
public Admin toAdmin(PasswordEncoder passwordEncoder) {
    Admin admin = new Admin();
    admin.setUsername(username);
    admin.setPassword(passwordEncoder.encode(password));
    //admin.setRoles(Collections.singleton(Role.ADMIN));
    return admin;
}
}