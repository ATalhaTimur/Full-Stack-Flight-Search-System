package com.TalhaTimur.FlightSearchAPI.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Define users and their roles
        if ("admin".equals(username)) {
            return new User("admin", "{noop}password", new ArrayList<>()); // No password encoding
        } else if ("Talha".equals(username)) {
            return new User("Talha", "{noop}12344", new ArrayList<>()); // No password encoding
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}