package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import com.example.Schreier_John_PRedictions_CaseStudy.model.Coach;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.model.UserStats;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.CoachRepository;
import com.example.Schreier_John_PRedictions_CaseStudy.services.CoachService;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserService;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoachController {
    @Autowired
    UserStatsService userStatsService;
    @Autowired
    CoachService coachService;
    @Autowired
    UserService userService;

    @GetMapping("/Choose_A_Coach")
    public String showChooseACoach(Model model) {
        UserStats userStats = new UserStats();
        model.addAttribute("userStats", userStats);
        return "Choose_A_Coach";
    }
    @PostMapping("/Choose_A_Coach")
    public String saveUserStats(@ModelAttribute("userStats") UserStats userStats)  {
        Coach coach = new Coach();
        User user = new User();
        user = userService.getLoggedUser();
        userStats.setUser(user);
        userStatsService.saveUserStats(userStats);
        return "redirect:/Profile_Page";
    }
//    Should maybe go in the Profile Controller if delete button is created:
    @GetMapping("/deleteUserStats")
    public String deleteUserStats(long id) {
        userStatsService.deleteUserStatsByEmail(id);
        return "redirect:/Profile_Page";
    }
}
