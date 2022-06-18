package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MarathonController {

    @GetMapping("/Marathon_Predictor")
    public String showMarathonPredictor() {
        return "Marathon_Predictor";
    }
}
