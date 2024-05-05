package com.example.bookmyshow.repositiory;

import com.example.bookmyshow.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryUserRepositiory implements UserRepositiory {

    Map<Long, User> users = new HashMap<>();
    private Long id = 0L;
    @Override
    public Optional<User> getUserById(Long id) {
        if(users.containsKey(id))
            return Optional.of(users.get(id));
        return Optional.empty();
    }

    public User saveUser(User user) {
        user.setId(id++);
        users.put(user.getId(), user);
        return user;
    }
}
