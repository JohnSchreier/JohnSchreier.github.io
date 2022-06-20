package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import com.example.Schreier_John_PRedictions_CaseStudy.model.UserStats;
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
    @GetMapping("/Choose_A_Coach")
    public String showChooseACoach(Model model) {
        UserStats userStats = new UserStats();
        model.addAttribute("userStats", userStats);
        return "Choose_A_Coach";
    }
    @PostMapping("/Choose_A_Coach")
    public String saveUserStats(@ModelAttribute("userStats") UserStats userStats)  {
        userStatsService.saveUserStats(userStats);
        return "redirect:/Choose_A_Coach";
    }
//    Should maybe go in the Profile Controller if delete button is created:
    @GetMapping("/deleteUserStats")
    public String deleteUserStats(String email) {
        userStatsService.deleteUserStatsByEmail(email);
        return "redirect:/Profile_Page";
    }
}
