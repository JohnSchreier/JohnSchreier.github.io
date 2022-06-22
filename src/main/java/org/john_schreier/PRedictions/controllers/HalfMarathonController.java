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

    @Qualifier("PRedictionServiceImpl")
    @Autowired
    PRedictionService predictionService;
    @Autowired
    UserService userService;
    @GetMapping("/Half-Marathon_Predictor")
    public String showHalfMarathonPredictorPage(Model model) throws PRException {
        User user = new User();
        user = userService.getLoggedUser();

        PRedictions predic = predictionService.getPredictionByUser(user);
        if(predic !=null) {
            model.addAttribute("predictions", predic);
        }else{
            model.addAttribute("predictions", new PRedictions());
        }
            model.addAttribute("exists", predictionService.existsPRedictionsByUser(user));
            return "Half_Marathon_Predictor";
        }
//       Create:
    @PostMapping("/Half-Marathon_Predictor/{predictions}")
    public String saveHalfCalculateRaceTime(@ModelAttribute("predictions") PRedictions predictions)
            throws PRException {

        User user = new User();
        user = userService.getLoggedUser();
        predictions.setUser(user);
        predictionService.savePrediction(predictions);
        System.out.println("~~~~saveHalfCalculateRaceTime method~~~~");
        return "redirect:/Profile_Page";
        }
//        Update:
    @RequestMapping(value="/Add_Half-Marathon_Predictor/{predictions}",method = {RequestMethod.GET, RequestMethod.POST})
    public String saveHalfTimeWhereMarExists(@PathVariable("predictions") String predictions)
            throws PRException{
        User user = new User();
        user = userService.getLoggedUser();
        predictionService.savePredictionMarExists(predictions,user.getEmail());

        System.out.println("~~~~saveHalfTimeWhereMarExists~~~~");
        return "redirect:/Profile_Page";

    }
}
