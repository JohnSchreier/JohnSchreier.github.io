package com.example.Schreier_John_PRedictions_CaseStudy.services;

import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserByEmail(String email);

    User registerUser(User user);


}
