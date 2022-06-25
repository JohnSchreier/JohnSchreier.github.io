package org.john_schreier.PRedictions.controllers;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.User;
import org.john_schreier.PRedictions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    //  Main controller for users logging in, registering, and going to the Home_Page
    @Autowired
    private UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    //  Maps the log in page
    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    //  Maps the Create_User page
    @GetMapping("/Create_User")
    public String userRegistration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "Create_User";
    }

    //  binds a new user's information to a User object
    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model) throws PRException {
        userService.registerUser(user);
        return "redirect:/";
    }

    //  maps Home_Page if a user logs in
    @GetMapping("/Home_Page")
    public String showHomePage() throws PRException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(auth.getName());

        return "Home_Page";
    }

    //  error page in case a user's credentials do not match
    @GetMapping("/errorPage")
    public String errorLogin() {
        return "indexerror";
    }


}