package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import com.example.Schreier_John_PRedictions_CaseStudy.exceptions.PRException;
import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.services.PRedictionService;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class MarathonController {

    @Qualifier("PRedictionServiceImpl")
    @Autowired
    PRedictionService predictionService;

    @Autowired
    UserService userService;
    @GetMapping("/Marathon_Predictor")
    public String showMarathonPredictorPage(Model model) {
        PRedictions predic = new PRedictions();
        model.addAttribute("predictions",predic);
        return "Marathon_Predictor";
    }
    @PostMapping("/Marathon_Predictor")
    public String saveMarCalculateRaceTime(@ModelAttribute("predictions") PRedictions predictions, Model model)
            throws PRException {

        User user = new User();
        user = userService.getLoggedUser();
        predictions.setUser(user);
        predictionService.savePrediction(predictions);

        return "redirect:/Profile_Page";
    }
}
