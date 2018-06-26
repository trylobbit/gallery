package com.satyla.controllers;

import com.satyla.model.User;
import com.satyla.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UsersBaseController {

    private final UserService userService;

    @Autowired
    public UsersBaseController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public String getAllUsers(Model model, @RequestParam(value = "page", required = false, defaultValue = "0")Integer page) {
        final Integer PAGE_SIZE =3;
        Page<User> pages = userService.getUsersList(page, PAGE_SIZE);
        model.addAttribute("allUsers", pages.getContent());
        model.addAttribute("actualPage", page);
        model.addAttribute("pages", pages.getTotalPages());
        return "users";
    }

    @PostMapping("users")
    public String deleteUser(@ModelAttribute User user) {
        userService.deleteUser(user.getId());
        return "redirect:/users";
    }
}
