package com.example.armstest;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "useradmin")
public class Admin implements UserDetails{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String username;
    private String family;
    private String surname;
    private String patronymic;
    private String fio;
    private String build;
    private String office;

//    @Enumerated(EnumType.STRING)
//    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
//    @CollectionTable(name = "admin_roles")
//    private Set<Role>roles = new HashSet<>();
    public Admin() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
        //Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
    }


    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
