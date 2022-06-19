package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import com.example.Schreier_John_PRedictions_CaseStudy.exceptions.PRException;
import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.services.PRedictionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HalfMarathonController {
    PRedictionService predicService;
    @GetMapping("/Half-Marathon_Predictor")
    public String showHalfMarathonPredictorPage(Model model) {
        PRedictions predic = new PRedictions();
        model.addAttribute("PRedictions",predic);
          return "Half_Marathon_Predictor";
    }
//    @PostMapping("/halfMarathonPrediction")
//    public String showHMPrediction(Model model) throws PRException {
//        User user = new User();
//        PRedictions predic = new PRedictions();
//        predicService.getPredictionByUser(user);
//        model.addAttribute("PRedictions",predic);
//
//        return null;
//    }
//    @PostMapping("/saveHalfMarathonPrediction")
//    public PRedictions saveHalfMarathonPrediction(PRedictions prediction){
//        return new PRedictionService().savePrediction(PRedictions prediction);
//    }
}
