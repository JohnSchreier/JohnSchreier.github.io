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
import org.springframework.web.bind.annotation.GetMapping;

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
            model.addAttribute("coachFirstName",userStatsService.findUserStatsByEmail(myUser.getUser().getEmail()).getCoach().getCoachFirstName());
            model.addAttribute("coachLastName",userStatsService.findUserStatsByEmail(myUser.getUser().getEmail()).getCoach().getCoachLastName());
            model.addAttribute("goals",userStatsService.findUserStatsByEmail(myUser.getUser().getEmail()).getGoals());
            model.addAttribute("history",userStatsService.findUserStatsByEmail(myUser.getUser().getEmail()).getHistory());
            model.addAttribute("halfMarathonPrediction",predictionService.findPredictionsByEmail(myUser.getUser().getEmail()).getHalfMarathonPrediction());
            model.addAttribute("marathonPrediction",predictionService.findPredictionsByEmail(myUser.getUser().getEmail()).getMarathonPrediction());
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong with the showProfilePage");
        }

        return "Profile_Page";
    }


//    @PostMapping("/halfMarathonPrediction")
//    public String saveHMPrediction(@ModelAttribute("halfMarathonPrediction") PRedictions predictions, Model model) throws PRException {
//        try {
//            User user = new User();
//            PRedictions predic = new PRedictions();
//            predictionService.savePrediction(predic);
//
//        }catch (PRException e) {
//            System.out.println(e.getMessage());
//        }
//        return "redirect:/Half_Marathon_Predictor";
//    }
    @GetMapping("/deleteUserStats")
    public String deleteUserStats(long id) {
        userStatsService.deleteUserStatsByEmail(id);
        return "redirect:/Profile_Page";
    }
//    @GetMapping("/deletePredictionsByEmail"){
//        predictionService.deletePredictionsByEmail();
//    }
}

//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.getUserByEmail(auth.getName())