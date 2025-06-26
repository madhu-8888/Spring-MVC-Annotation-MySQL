package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class HomeController {
	
	private UserService userService; 

	// Constructor Injection (for real apps)
	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
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
        try {
            userService.createUser(user);  // <<<<< Save user to DB here!
        } catch (Exception e) {
            e.printStackTrace();
            // You can add error handling and show error page if needed
        }
        return new ModelAndView("user-confirmation", "user", user);
    }
    
   /* @PostMapping("/processForm")
    public ModelAndView processForm(@ModelAttribute("user") User user) {
        return new ModelAndView("user-confirmation", "user", user);
    }*/
}
