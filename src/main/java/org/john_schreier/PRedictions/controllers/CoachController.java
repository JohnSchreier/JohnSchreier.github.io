package org.john_schreier.PRedictions.controllers;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.Coach;
import org.john_schreier.PRedictions.model.User;
import org.john_schreier.PRedictions.model.UserStats;
import org.john_schreier.PRedictions.services.CoachService;
import org.john_schreier.PRedictions.services.UserService;
import org.john_schreier.PRedictions.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String saveUserStats(@ModelAttribute("userStats") UserStats userStats) throws PRException {
        Coach coach = new Coach();
        User user = new User();
        user = userService.getLoggedUser();
        userStats.setUser(user);
        userStatsService.saveUserStats(userStats);
        return "redirect:/Profile_Page";
    }

}
