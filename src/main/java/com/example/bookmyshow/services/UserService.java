package com.example.bookmyshow.services;

import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositiory.UserRepositiory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepositiory userRepositiory;
    public UserService(UserRepositiory userRepositiory) {
        this.userRepositiory = userRepositiory;
    }
    public User createUser(String name, String email) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        userRepositiory.saveUser(newUser);
        return newUser;
    }
}
