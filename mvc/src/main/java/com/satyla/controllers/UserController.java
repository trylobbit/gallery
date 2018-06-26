package com.satyla.controllers;

import com.satyla.model.User;
import com.satyla.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String userLoginForm(Model model) {
        User userLog = new User();
        model.addAttribute("user", userLog);
        return "login";
    }

    @PostMapping("/login")
    public String userLogin() {
        return "home";
    }

    @GetMapping("/register")
    public String registerUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String userSubmit(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {
        if (userService.hasAnyError(bindingResult, user)) {
            String errorMessage = userService.getRegisterErrorMessage(bindingResult);
            LOG.error("Error, occurred user account cannot be create", user);
            model.addAttribute("message", errorMessage);
            return "register";
        } else {
            userService.addUser(user);
            LOG.info("Success, User account was created", user);
            return "redirect:/home";
        }
    }


}

