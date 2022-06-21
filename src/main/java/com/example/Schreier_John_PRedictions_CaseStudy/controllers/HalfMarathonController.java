package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HalfMarathonController {

    @GetMapping("/Half-Marathon_Predictor")
    public String showHalfMarathonPredictorPage(Model model) {
        PRedictions predic = new PRedictions();
        model.addAttribute("PRedictions",predic);
          return "Half_Marathon_Predictor";
        }
    }
