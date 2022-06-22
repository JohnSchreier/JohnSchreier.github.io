package org.john_schreier.PRedictions.controllers;
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

    @Autowired
    private UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value= "/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    @GetMapping("/Create_User")
    public String userRegistration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "Create_User";
    }
    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model) {
        userService.registerUser(user);
        return "redirect:/";
    }

    @GetMapping("/Home_Page")
    public String showHomePage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(auth.getName());

        return "Home_Page";
    }
    @GetMapping("/errorPage")
    public String errorLogin() {
        return "indexerror";
    }




}