package com.willsalas.registration_login.controller;

import com.willsalas.registration_login.entity.User;
import com.willsalas.registration_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("checkUser", user);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {

        if(!userService.checkUserExists(email, password)) {
            return "redirect:/login";
        }
        User user = userService.findByEmail(email);
        model.addAttribute(user);
        return "personal";

    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute User user) {
        User dataUser = userService.findByEmail(user.getEmail());
        if(dataUser != null) {
            return "redirect:/registration";
        }

        userService.saveUser(user);

        return "personal";
    }
}
