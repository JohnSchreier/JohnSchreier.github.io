package org.john_schreier.PRedictions.services;

import org.john_schreier.PRedictions.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User getUserByEmail(String email);

    User registerUser(User user);

    User getLoggedUser();

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;


}
