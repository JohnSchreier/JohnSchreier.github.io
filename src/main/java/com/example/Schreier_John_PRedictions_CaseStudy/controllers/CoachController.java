package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoachController {

    @GetMapping("/Choose_A_Coach")
    public String showChooseACoach() {
        return "Choose_A_Coach";
    }
}
