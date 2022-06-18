package com.example.Schreier_John_PRedictions_CaseStudy.model;

import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

public class MyUserDetails implements UserDetails{

    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
    public User getUser() {
        return user;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
