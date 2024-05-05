package com.example.bookmyshow.controller;

import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User createUser(String name, String email)
    {
        return userService.createUser(name, email);
    }
}
