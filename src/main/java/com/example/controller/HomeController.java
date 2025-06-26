package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;

@Controller
public class HomeController {
    @GetMapping("/welcomePage")
    public String home(Model model) {
    	model.addAttribute("message", "Welcome to Full Spring MVC Example!");
        return "home";
    }
    
    @GetMapping("/showForm")
    public ModelAndView showForm() {
        ModelAndView mav = new ModelAndView("user-form");
        mav.addObject("user", new User());
        return mav;
    }
    
    @PostMapping("/processForm")
    public ModelAndView processForm(@ModelAttribute("user") User user) {
        return new ModelAndView("user-confirmation", "user", user);
    }
}
