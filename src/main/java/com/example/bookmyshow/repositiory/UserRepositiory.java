package com.example.bookmyshow.repositiory;

import com.example.bookmyshow.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositiory {
    Optional<User> getUserById(Long id);
    User saveUser(User user);
}
