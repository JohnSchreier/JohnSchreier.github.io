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
import org.springframework.web.bind.annotation.*;

@Controller
public class HalfMarathonController {
    //  Controller for creating user's personalized half-marathon race predictions. Each user gets one set of predictions
    @Qualifier("PRedictionServiceImpl")
    @Autowired
    PRedictionService predictionService;
    @Autowired
    UserService userService;

    //  Loads Half_Marathon_Predictor Page
    @GetMapping("/Half-Marathon_Predictor")
    public String showHalfMarathonPredictorPage(Model model) throws PRException {
        User user = new User();
        user = userService.getLoggedUser();

        PRedictions predic = predictionService.getPredictionByUser(user);
        if (predic != null) {
            model.addAttribute("predictions", predic);
        } else {
            model.addAttribute("predictions", new PRedictions());
        }
        model.addAttribute("exists", predictionService.existsPRedictionsByUser(user));
        return "Half_Marathon_Predictor";
    }

    //       Creates new half marathon prediction:
    @PostMapping("/Half-Marathon_Predictor")
    public String saveHalfCalculateRaceTime(@ModelAttribute PRedictions predictions, Model model)
            throws PRException {

        User user = userService.getLoggedUser();
        predictions.setUser(user);
        predictionService.savePrediction(predictions);
        System.out.println("~~~~saveHalfCalculateRaceTime method~~~~");
        return "redirect:/Profile_Page";
    }

    //        Updates set of existing predictions:
    @RequestMapping(value = "/Add_Half-Marathon_Predictor/{predictions}", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveHalfTimeWhereMarExists(@PathVariable("predictions") String predictions)
            throws PRException {
        User user = new User();
        user = userService.getLoggedUser();
        predictionService.savePredictionMarExists(predictions, user.getEmail());
        System.out.println("~~~~saveHalfTimeWhereMarExists~~~~");
        return "redirect:/Profile_Page";

    }
}
