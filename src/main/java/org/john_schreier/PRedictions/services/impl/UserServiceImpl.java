package org.john_schreier.PRedictions.services.impl;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.MyUserDetails;
import org.john_schreier.PRedictions.model.User;
import org.john_schreier.PRedictions.repository.UserRepository;
import org.john_schreier.PRedictions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
//    Implmentation of the UserService which connects the User repo to the view.
//    Used for logging in and registering, as well as checking who the logged in user is.
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bcrypt;


    //method to get user by email
    @Override
    public User getUserByEmail(String email) throws PRException {
        if (email == null) {
            throw new PRException("Cannot get user by this email address");
        }
        User user = userRepository.findUserByEmail(email);
        return user;

    }

    //    method to save to repo and encrypt user password:
    @Override
    public User registerUser(User user) throws PRException {
        if (user == null) {
            throw new PRException("Cannot register user");
        }
        user.setPassword(bcrypt.encode(user.getPassword()));
        return userRepository.save(user);

    }

    @Override
    public User getLoggedUser() throws PRException {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            User user = getUserByEmail(currentPrincipalName);
            return user;
        } catch (PRException p){
            throw new PRException("Cannot find logged in user");
        }
    }

    //add method
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        System.out.println("User:  " + user);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new MyUserDetails(user);
    }
}