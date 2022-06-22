package org.john_schreier.PRedictions.controllers;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.PRedictions;
import org.john_schreier.PRedictions.model.User;
import org.john_schreier.PRedictions.services.PRedictionService;
import org.john_schreier.PRedictions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HalfMarathonController {

    @Qualifier("PRedictionServiceImpl")
    @Autowired
    PRedictionService predictionService;
    @Autowired
    UserService userService;
    @GetMapping("/Half-Marathon_Predictor")
    public String showHalfMarathonPredictorPage(Model model) {
        PRedictions predictions = new PRedictions();

        model.addAttribute("predictions",predictions);
          return "Half_Marathon_Predictor";
        }
    @PostMapping("/Half-Marathon_Predictor")
    public String saveCalculateRaceTime(@ModelAttribute("predictions") PRedictions predictions, Model model)
                                        throws PRException {

        User user = new User();
        user = userService.getLoggedUser();
        predictions.setUser(user);
        predictionService.savePrediction(predictions);

        return "redirect:/Profile_Page";
        }
//        PostMapping("/Half-Marathon_Predictor")
//            public String addHalfMarathon
    }
