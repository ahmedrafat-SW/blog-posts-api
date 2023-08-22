package com.dev.blogpostsapi.registration;

import com.dev.blogpostsapi.data.entity.User;
import com.dev.blogpostsapi.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public boolean isUserValid(String email, String password) {
        // Return true if the user exists and the password matches, otherwise return false
        User user = repository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }



}
