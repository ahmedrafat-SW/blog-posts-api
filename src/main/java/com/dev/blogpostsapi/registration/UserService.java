package com.dev.blogpostsapi.registration;

import com.dev.blogpostsapi.model.User;
import com.dev.blogpostsapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
