package com.example.Schreier_John_PRedictions_CaseStudy.controllers;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("userForm", new User());
        return "index";
    }

    @GetMapping("/Create_User")
    public String createUser(Model model) {
        model.addAttribute("userForm", new User());
        return "Create_User";
    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model) {

        userService.registerUser(user);
        return "redirect:/";
    }

    @GetMapping("/errorPage")
    public String errorLogin() {
        return "indexerror";
    }

    @GetMapping("/Home_Page")
    public String showHomePage() {
        return "Home_Page";
    }


    @GetMapping("/Half-Marathon_Predictor")
    public String showHalfMarathonPredictor() { return "Half_Marathon_Predictor";    }

    @GetMapping("/Marathon_Predictor")
    public String showMarathonPredictor() {
        return "Marathon_Predictor";
    }
}