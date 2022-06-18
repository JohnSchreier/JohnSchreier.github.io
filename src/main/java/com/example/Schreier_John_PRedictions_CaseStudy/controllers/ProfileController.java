package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/Profile_Page")
    public String showProfilePage(Model model, User user) {
        model.addAttribute("firstName", userService.getUserByEmail(user.getEmail()).getFirstName());
//        model.addAttribute("halfMarathonPrediction",PRedictionsService);
        System.out.println(userService.getUserByEmail(user.getEmail()).getFirstName());
        return "Profile_Page";
    }
}

//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.getUserByEmail(auth.getName())