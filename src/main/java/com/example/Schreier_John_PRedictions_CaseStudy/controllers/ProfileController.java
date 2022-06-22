package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import com.example.Schreier_John_PRedictions_CaseStudy.exceptions.PRException;
import com.example.Schreier_John_PRedictions_CaseStudy.model.MyUserDetails;
import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.services.PRedictionService;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserService;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
            model.addAttribute("halfMarathonPrediction",predictionService.findPredictionsByEmail(myUser.getUser().getEmail()).getHalfMarathonPrediction());
        } catch(Exception e){
            e.printStackTrace();
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
}

//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.getUserByEmail(auth.getName())