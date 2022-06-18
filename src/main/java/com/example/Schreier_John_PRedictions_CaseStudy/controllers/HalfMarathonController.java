package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HalfMarathonController {
    @GetMapping("/Half-Marathon_Predictor")
    public String showHalfMarathonPredictor() { return "Half_Marathon_Predictor";    }
}
