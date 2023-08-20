package com.dev.blogpostsapi.controller;

import com.dev.blogpostsapi.dto.UserDTO;
import com.dev.blogpostsapi.model.User;
import com.dev.blogpostsapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserRepository repository;
//    private final BCryptPasswordEncoder passwordEncoder;



    @GetMapping
    public List<UserDTO> getAllUsers(){
        return repository.findAll()
                .stream()
                .map(user -> {
                    return new UserDTO(user.getUserId(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getEmail());
                }).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public Optional<UserDTO> getUserById(@PathVariable Long id){
        return repository.findById(id)
                .map(user -> {
                    return new UserDTO(user.getUserId(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getEmail());
                });
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        User savedUser = repository.save(user);
        if (repository.findByEmail(user.getEmail()) != null){
            throw new IllegalArgumentException("Email Already exists ");
        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        User user = repository.findById(id).get();
        repository.delete(user);
    }

}
