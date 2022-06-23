package org.john_schreier.PRedictions.controllers;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.MyUserDetails;
import org.john_schreier.PRedictions.model.User;
import org.john_schreier.PRedictions.services.PRedictionService;
import org.john_schreier.PRedictions.services.UserService;
import org.john_schreier.PRedictions.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserStatsService userStatsService;


    @Qualifier("PRedictionServiceImpl")
    @Autowired
    private PRedictionService predictionService;

    @GetMapping("/Profile_Page")
    public String showProfilePage(Model model, User user) throws PRException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUser = (MyUserDetails) auth.getPrincipal();
        try {
            model.addAttribute("coachFirstName", userStatsService.findUserStatsByEmail(myUser.getUser().getEmail()).getCoach().getCoachFirstName());
            model.addAttribute("coachLastName", userStatsService.findUserStatsByEmail(myUser.getUser().getEmail()).getCoach().getCoachLastName());
            model.addAttribute("goals", userStatsService.findUserStatsByEmail(myUser.getUser().getEmail()).getGoals());
            model.addAttribute("history", userStatsService.findUserStatsByEmail(myUser.getUser().getEmail()).getHistory());
            model.addAttribute("halfMarathonPrediction", predictionService.findPredictionsByEmail(myUser.getUser().getEmail()).getHalfMarathonPrediction());
            model.addAttribute("marathonPrediction", predictionService.findPredictionsByEmail(myUser.getUser().getEmail()).getMarathonPrediction());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong with the showProfilePage");
        }
        return "Profile_Page";
    }

    @GetMapping("/delete")
    public RedirectView deleteUserPRedictions() {
        User user = userService.getLoggedUser();
        predictionService.deletePRedictionsByUser(user);
        System.out.println("~~~~~~~~~~~~~~User Predictions Removed~~~~~~~~~~");
        return new RedirectView("/Profile_Page");
    }
}